package ru.chimchima

import com.intellij.ide.ApplicationLoadListener
import com.intellij.openapi.application.Application
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.SystemInfo
import com.intellij.ui.MacCustomAppIcon
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@Suppress("UnstableApiUsage")
class IconChanger : ApplicationLoadListener {
    private val logger = Logger.getInstance(IconChanger::class.java)

    override suspend fun beforeApplicationLoaded(application: Application, configPath: Path) {
        if (SystemInfo.isMac) {
            println("Setting custom icon...")
            val appPath = PathManager.getHomePath()
            val iconPath = Paths.get(appPath, "Resources", "custom.icns")
            println("Copying icon to $iconPath...")
            val sourcePath = this::class.java.getResourceAsStream("/classic-icon.icns") ?: error("Failed to load icon")
            Files.copy(sourcePath, iconPath, StandardCopyOption.REPLACE_EXISTING)
            println("ok)")

            MacCustomAppIcon.setCustom(value = true, showDialog = false)
        }
    }
}
