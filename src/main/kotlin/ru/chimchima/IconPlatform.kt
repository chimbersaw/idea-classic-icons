package ru.chimchima

import com.intellij.openapi.application.ApplicationNamesInfo

enum class IconPlatform(val label: String) {
    INTELLIJ_IDEA("IntelliJ IDEA"),
    CLION("CLion"),
    PYCHARM("PyCharm"),
    GOLAND("GoLand"),
    WEBSTORM("WebStorm"),
    PHPSTORM("PhpStorm"),
    ANDROID_STUDIO("Android Studio"),
    RIDER("JetBrains Rider"),
    RUST_ROVER("Rust Rover"),
    RUBY_MINE("RubyMine");

    companion object {
        val CURRENT = ApplicationNamesInfo.getInstance().fullProductName.let { name ->
            entries.find { it.label == name }
        }
    }
}
