package ru.chimchima

import com.intellij.ide.plugins.DynamicPluginListener
import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.ide.plugins.PluginManagerConfigurable
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.util.SystemInfo
import com.intellij.ui.MacCustomAppIcon
import com.intellij.util.application
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

class IconChanger : DynamicPluginListener {
    override fun pluginLoaded(pluginDescriptor: IdeaPluginDescriptor) {
        if (pluginDescriptor.pluginId.idString == "ru.chimchima.idea-classic-icons") {
            application.invokeLater {
                println("plugin load")
                changeIcon()
                PluginManagerConfigurable.shutdownOrRestartApp()
            }
        }
    }

    override fun beforePluginUnload(pluginDescriptor: IdeaPluginDescriptor, isUpdate: Boolean) {
        if (pluginDescriptor.pluginId.idString == "ru.chimchima.idea-classic-icons") {
            println("plugin unload")
            MacCustomAppIcon.setCustom(value = false, showDialog = false)
        }
    }

    companion object {
        val settings = IconSettings.getInstance()

        fun changeIcon() {
            if (SystemInfo.isMac) {
                println("Setting custom icon...")

                val iconPath = Paths.get(PathManager.getHomePath(), "Resources", "custom.icns")
                val current = settings.state.currentIcon
                val icon = settings.state.selectedIcon
                println("Current icon is ${current?.label}, selected icon is ${icon.label}")
                if (current != icon || MacCustomAppIcon.isCustom() == false) {
                    println("Copying icon to $iconPath...")
                    Files.copy(icon.load(), iconPath, StandardCopyOption.REPLACE_EXISTING)

                    MacCustomAppIcon.setCustom(value = true, showDialog = false)
                    settings.state.currentIcon = icon
                    println("done")
                }
            }
        }
    }
}
