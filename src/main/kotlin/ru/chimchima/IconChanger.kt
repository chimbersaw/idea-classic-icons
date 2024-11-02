package ru.chimchima

import com.intellij.ide.AppLifecycleListener
import com.intellij.ide.plugins.DynamicPluginListener
import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.Service.Level
import com.intellij.openapi.util.SystemInfo
import com.intellij.ui.AppIcon
import com.intellij.ui.MacCustomAppIcon
import com.intellij.util.application
import com.intellij.util.ui.ImageUtil
import ru.chimchima.utils.IconUtils
import java.awt.Image
import java.awt.Taskbar
import java.awt.image.BufferedImage
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import kotlin.io.path.readBytes

private const val CUSTOM_ICNS = "custom.icns"

@Service(Level.APP)
class IconChanger : DynamicPluginListener, AppLifecycleListener {
    private val settings = IconSettings.getInstance()
    private val resourcesPath = Paths.get(PathManager.getHomePath(), "Resources")
    private val customIconPath = resourcesPath.resolve(CUSTOM_ICNS)

    private fun setDockIcon(image: Image) = try {
        val bufferedImage = ImageUtil.toBufferedImage(image)
        Taskbar.getTaskbar().iconImage = bufferedImage

        val appIcon = AppIcon.getInstance()
        val imageField = appIcon.javaClass.declaredFields.first { it.type == BufferedImage::class.java }
        imageField.isAccessible = true
        imageField.set(appIcon, bufferedImage)
    } catch (e: Exception) {
        println("Failed to set dock icon")
        e.printStackTrace()
    }

    fun changeIcon() {
        if (SystemInfo.isMac) {
            println("Setting custom icon...")

            val icon = settings.state.selectedIcon
            val scaled = settings.state.macStyledIcons.not()
            println("Selected icon is ${icon.label}")

            println("Copying custom icon to $customIconPath...")
            val icns = icon.loadIcns(scaled)
            Files.copy(icns, customIconPath, StandardCopyOption.REPLACE_EXISTING)
            MacCustomAppIcon.setCustom(value = true, showDialog = false)

            println("Changing current dock icon...")
            val image = icon.loadImage(scaled)
            setDockIcon(image)

            println("done")
        } else if (SystemInfo.isWindows) {
            println("Not on macOS, i am here")
        }
    }

    override fun pluginLoaded(pluginDescriptor: IdeaPluginDescriptor) {
        if (pluginDescriptor.pluginId.idString == "ru.chimchima.idea-classic-icons") {
            println("plugin load")
            changeIcon()
        }
    }

    override fun beforePluginUnload(pluginDescriptor: IdeaPluginDescriptor, isUpdate: Boolean) {
        if (pluginDescriptor.pluginId.idString == "ru.chimchima.idea-classic-icons") {
            println("plugin unload")
            if (SystemInfo.isMac) {
                MacCustomAppIcon.setCustom(value = false, showDialog = false)

                val resources = Files.list(resourcesPath).toList()
                val originalIcon = resources.find {
                    val name = it.fileName.toString()
                    name.endsWith(".icns") && name != CUSTOM_ICNS
                } ?: return

                val image = IconUtils.getImageFromIcns(originalIcon.readBytes())
                setDockIcon(image)
            }
        }
    }

    override fun appFrameCreated(commandLineArgs: List<String>) {
        // After an update, the custom icon is lost
        if (SystemInfo.isMac && Files.notExists(customIconPath)) {
            changeIcon()
        }
    }

    companion object {
        fun getInstance() = application.getService(IconChanger::class.java)
    }
}
