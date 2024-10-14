package ru.chimchima

import com.intellij.openapi.application.ApplicationNamesInfo

enum class IconPlatform(val label: String) {
    INTELLIJ_IDEA("IntelliJ IDEA"),
    CLION("CLion"),
    PYCHARM("PyCharm"),
    GOLAND("GoLand"),
    WEBSTORM("WebStorm"),
    PHPSTORM("PhpStorm"),
    RIDER("JetBrains Rider"),
    RUST_ROVER("RustRover"),
    RUBY_MINE("RubyMine");

    companion object {
        val CURRENT = ApplicationNamesInfo.getInstance().fullProductName.let { name ->
            entries.find { it.label == name }
        }
    }
}
