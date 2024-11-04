package ru.chimchima

import com.intellij.openapi.application.ApplicationNamesInfo

enum class IconPlatform(val label: String, val shortName: String) {
    INTELLIJ_IDEA("IntelliJ IDEA", "idea"),
    PYCHARM("PyCharm", "pycharm"),
    CLION("CLion", "clion"),
    GOLAND("GoLand", "goland"),
    WEBSTORM("WebStorm", "webstorm"),
    PHPSTORM("PhpStorm", "phpstorm"),
    RIDER("JetBrains Rider", "rider"),
    RUST_ROVER("RustRover", "rustrover"),
    RUBY_MINE("RubyMine", "rubymine"),
    OTHER("Other", "other");

    companion object {
        val CURRENT = ApplicationNamesInfo.getInstance().fullProductName.let { name ->
            entries.find { it.label == name } ?: OTHER
        }
    }
}
