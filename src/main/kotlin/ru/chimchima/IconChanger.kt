package ru.chimchima

import com.intellij.ide.AppLifecycleListener
import com.intellij.ide.plugins.DynamicPluginListener
import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.ide.plugins.PluginManagerConfigurable
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.application.ex.ApplicationEx.EXIT_CONFIRMED
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.Service.Level
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.util.SystemInfo
import com.intellij.ui.AppIcon
import com.intellij.ui.MacCustomAppIcon
import com.intellij.util.application
import com.intellij.util.system.CpuArch
import com.intellij.util.ui.ImageUtil
import ru.chimchima.utils.IconUtils
import java.awt.Image
import java.awt.Taskbar
import java.awt.image.BufferedImage
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import kotlin.io.path.listDirectoryEntries
import kotlin.io.path.readBytes

private const val CUSTOM_ICNS = "custom.icns"
private const val IDEA_CLASSIC_ICONS = "idea-classic-icons"
private const val IDEA_CLASSIC_ICONS_FQN = "ru.chimchima.$IDEA_CLASSIC_ICONS"

@Service(Level.APP)
class IconChanger : DynamicPluginListener, AppLifecycleListener {
    private val settings = IconSettings.getInstance()
    private val homePath = Paths.get(PathManager.getHomePath())
    private val macResourcesPath = homePath.resolve("Resources")
    private val customIconPath = macResourcesPath.resolve(CUSTOM_ICNS)

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
            icon.loadIcns(scaled).use {
                Files.copy(it, customIconPath, StandardCopyOption.REPLACE_EXISTING)
            }
            MacCustomAppIcon.setCustom(value = true, showDialog = false)

            println("Changing current dock icon...")
            val image = icon.loadImage(scaled)
            setDockIcon(image)

            println("done")
        } else if (SystemInfo.isWindows) {
            println("Setting custom icon...")

            changeIconWindows()
        }
    }

    private fun changeIconWindows() {
        val answer = PluginManagerConfigurable.showRestartDialog()
        if (answer == Messages.YES) {
            val ide = IconPlatform.CURRENT.shortName
            val exeName = if (CpuArch.is32Bit()) {
                "${ide}.exe"
            } else {
                "${ide}64.exe"
            }

            val javaPath = homePath.resolve("jbr").resolve("bin").resolve("java.exe")
            val jarPath = PathManager.getPluginsDir().resolve(IDEA_CLASSIC_ICONS).resolve("lib")
                .listDirectoryEntries("org.eclipse.equinox.p2.publisher.eclipse*.jar").first()
            val className = "org.eclipse.pde.internal.swt.tools.IconExe"
            val firstArg = homePath.resolve("bin").resolve(exeName)
            val secondArg = "Y:\\IdeaProjects\\win-idea\\clion.ico"

            val powershellScript = """
                & '$javaPath' -cp '$jarPath' $className '$firstArg' '$secondArg';
                if (Test-Path `${"$"}env:LOCALAPPDATA\IconCache.db) {
                    Remove-Item -Path `${"$"}env:LOCALAPPDATA\IconCache.db -Force
                };
                if (Test-Path "`${"$"}env:LOCALAPPDATA\Microsoft\Windows\Explorer\iconcache*") {
                    Remove-Item -Path "`${"$"}env:LOCALAPPDATA\Microsoft\Windows\Explorer\iconcache*" -Force
                };
                Stop-Process -Name explorer -Force
            """.trimIndent()

            val command = listOf(
                "powershell.exe",
                "-NoProfile",
                "-NonInteractive",
                "-Command",
                powershellScript
            )

            val restart = application.javaClass.getMethod("restart", Int::class.java, Array<String>::class.java)
            restart.invoke(application, EXIT_CONFIRMED, command.toTypedArray())
        }
    }

    override fun pluginLoaded(pluginDescriptor: IdeaPluginDescriptor) {
        if (pluginDescriptor.pluginId.idString == IDEA_CLASSIC_ICONS_FQN) {
            println("plugin load")
            changeIcon()
        }
    }

    override fun beforePluginUnload(pluginDescriptor: IdeaPluginDescriptor, isUpdate: Boolean) {
        if (pluginDescriptor.pluginId.idString == IDEA_CLASSIC_ICONS_FQN) {
            println("plugin unload")
            if (SystemInfo.isMac) {
                MacCustomAppIcon.setCustom(value = false, showDialog = false)

                val platformName = IconPlatform.CURRENT.shortName
                val originalIcon = macResourcesPath.resolve("$platformName.icns")
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
