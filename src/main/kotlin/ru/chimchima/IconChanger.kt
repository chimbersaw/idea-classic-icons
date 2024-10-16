package ru.chimchima

import com.intellij.ide.plugins.DynamicPluginListener
import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.Service.Level
import com.intellij.openapi.util.SystemInfo
import com.intellij.ui.MacCustomAppIcon
import com.intellij.util.application
import com.intellij.util.ui.ImageUtil
import java.awt.Image
import java.awt.Taskbar
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@Service(Level.APP)
class IconChanger : DynamicPluginListener {
    private val settings = IconSettings.getInstance()

    private fun setDockIcon(image: Image) {
        Taskbar.getTaskbar().iconImage = ImageUtil.toBufferedImage(image)
    }

    fun changeIcon() {
        if (SystemInfo.isMac) {
            println("Setting custom icon...")

            val customIconPath = Paths.get(PathManager.getHomePath(), "Resources", "custom.icns")
            val current = settings.state.currentIcon
            val icon = settings.state.selectedIcon
            println("Current icon is ${current?.label}, selected icon is ${icon.label}")

            if (current != icon || !MacCustomAppIcon.isCustom()) {
                println("Copying custom icon to $customIconPath...")
                Files.copy(icon.loadData(), customIconPath, StandardCopyOption.REPLACE_EXISTING)
                MacCustomAppIcon.setCustom(value = true, showDialog = false)
                settings.state.currentIcon = icon

                println("Changing current dock icon...")
                setDockIcon(icon.loadImage())

                println("done")
            }
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
            MacCustomAppIcon.setCustom(value = false, showDialog = false)
        }
    }

    companion object {
        fun getInstance() = application.getService(IconChanger::class.java)
    }
}
