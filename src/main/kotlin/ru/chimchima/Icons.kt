package ru.chimchima

import com.intellij.openapi.util.IconLoader
import com.intellij.util.IconUtil
import ru.chimchima.IconPlatform.*

enum class Icons(
    val platform: IconPlatform,
    val label: String,
    val path: String,
    val default: Boolean = false
) {
    IDEA_ULTIMATE_11_0_2(INTELLIJ_IDEA, "IDEA Ultimate 11", "/ideaU/ideaU-11.0.2.icns"),
    IDEA_ULTIMATE_12_1_8(INTELLIJ_IDEA, "IDEA Ultimate 12", "/ideaU/ideaU-12.1.8.icns"),
    IDEA_ULTIMATE_14_0_5(INTELLIJ_IDEA, "IDEA Ultimate 14", "/ideaU/ideaU-14.0.5.icns"),
    IDEA_ULTIMATE_2016_1_4(INTELLIJ_IDEA, "IDEA Ultimate 2016", "/ideaU/ideaU-2016.1.4.icns"),
    IDEA_ULTIMATE_2020_3_4(INTELLIJ_IDEA, "IDEA Ultimate 2020", "/ideaU/ideaU-2020.3.4.icns", default = true),
    IDEA_ULTIMATE_2021_2_4(INTELLIJ_IDEA, "IDEA Ultimate 2021", "/ideaU/ideaU-2021.2.4.icns"),
    IDEA_ULTIMATE_2023_3_8(INTELLIJ_IDEA, "IDEA Ultimate 2023", "/ideaU/ideaU-2023.3.8.icns"),
    IDEA_ULTIMATE_2024_2_3(INTELLIJ_IDEA, "IDEA Ultimate 2024", "/ideaU/ideaU-2024.2.3.icns"),

    IDEA_COMMUNITY_11_0_2(INTELLIJ_IDEA, "IDEA Community 11", "/ideaC/ideaC-11.0.2.icns"),
    IDEA_COMMUNITY_12_1_8(INTELLIJ_IDEA, "IDEA Community 12", "/ideaC/ideaC-12.1.8.icns"),
    IDEA_COMMUNITY_14_0_5(INTELLIJ_IDEA, "IDEA Community 14", "/ideaC/ideaC-14.0.5.icns"),
    IDEA_COMMUNITY_2016_1_4(INTELLIJ_IDEA, "IDEA Community 2016", "/ideaC/ideaC-2016.1.4.icns"),
    IDEA_COMMUNITY_2020_3_4(INTELLIJ_IDEA, "IDEA Community 2020", "/ideaC/ideaC-2020.3.4.icns"),
    IDEA_COMMUNITY_2021_2_4(INTELLIJ_IDEA, "IDEA Community 2021", "/ideaC/ideaC-2021.2.4.icns"),
    IDEA_COMMUNITY_2023_3_8(INTELLIJ_IDEA, "IDEA Community 2023", "/ideaC/ideaC-2023.3.8.icns"),
    IDEA_COMMUNITY_2024_2_3(INTELLIJ_IDEA, "IDEA Community 2024", "/ideaC/ideaC-2024.2.3.icns"),

    PYCHARM_PROFESSIONAL_1_1_1(PYCHARM, "PyCharm 1", "/pycharmP/pycharmP-1.1.1.icns"),
    PYCHARM_PROFESSIONAL_2_5_2(PYCHARM, "PyCharm 2", "/pycharmP/pycharmP-2.5.2.icns"),
    PYCHARM_PROFESSIONAL_2016_1_5(PYCHARM, "PyCharm 2016", "/pycharmP/pycharmP-2016.1.5.icns"),
    PYCHARM_PROFESSIONAL_2020_3_5(PYCHARM, "PyCharm 2020", "/pycharmP/pycharmP-2020.3.5.icns", default = true),
    PYCHARM_PROFESSIONAL_2021_2_4(PYCHARM, "PyCharm 2021", "/pycharmP/pycharmP-2021.2.4.icns"),
    PYCHARM_PROFESSIONAL_2023_3_7(PYCHARM, "PyCharm 2023", "/pycharmP/pycharmP-2023.3.7.icns"),
    PYCHARM_PROFESSIONAL_2024_2_3(PYCHARM, "PyCharm 2024", "/pycharmP/pycharmP-2024.2.3.icns"),

    PYCHARM_COMMUNITY_3_0_3(PYCHARM, "PyCharm Community 3", "/pycharmC/pycharmC-3.0.3.icns"),
    PYCHARM_COMMUNITY_2016_3_6(PYCHARM, "PyCharm Community 2016", "/pycharmC/pycharmC-2016.3.6.icns"),
    PYCHARM_COMMUNITY_2017_1_8(PYCHARM, "PyCharm Community 2017", "/pycharmC/pycharmC-2017.1.8.icns"),
    PYCHARM_COMMUNITY_2020_3_5(PYCHARM, "PyCharm Community 2020", "/pycharmC/pycharmC-2020.3.5.icns"),
    PYCHARM_COMMUNITY_2021_2_4(PYCHARM, "PyCharm Community 2021", "/pycharmC/pycharmC-2021.2.4.icns"),
    PYCHARM_COMMUNITY_2023_3_7(PYCHARM, "PyCharm Community 2023", "/pycharmC/pycharmC-2023.3.7.icns"),
    PYCHARM_COMMUNITY_2024_2_3(PYCHARM, "PyCharm Community 2024", "/pycharmC/pycharmC-2024.2.3.icns"),

    CLION_1_1_2(CLION, "CLion 1.1.2", "/clion/clion-1.1.2.icns"),
    CLION_2016_1_4(CLION, "CLion 2016", "/clion/clion-2016.1.4.icns"),
    CLION_2020_3_4(CLION, "CLion 2020", "/clion/clion-2020.3.4.icns", default = true),
    CLION_2021_2_4(CLION, "CLion 2021", "/clion/clion-2021.2.4.icns"),
    CLION_2023_3_6(CLION, "CLion 2023", "/clion/clion-2023.3.6.icns"),
    CLION_2024_2_2(CLION, "CLion 2024", "/clion/clion-2024.2.2.icns"),

    GOLAND_2017_3_5(GOLAND, "GoLand 2017", "/goland/goland-2017.3.5.icns"),
    GOLAND_2019_2_5(GOLAND, "GoLand 2019", "/goland/goland-2019.2.5.icns"),
    GOLAND_2020_3_5(GOLAND, "GoLand 2020", "/goland/goland-2020.3.5.icns", default = true),
    GOLAND_2021_2_5(GOLAND, "GoLand 2021", "/goland/goland-2021.2.5.icns"),
    GOLAND_2023_3_8(GOLAND, "GoLand 2023", "/goland/goland-2023.3.8.icns"),
    GOLAND_2024_2_3(GOLAND, "GoLand 2024", "/goland/goland-2024.2.3.icns"),

    WEBSTORM_1_0_2(WEBSTORM, "WebStorm 1", "/webstorm/webstorm-1.0.2.icns"),
    WEBSTORM_4_0_3(WEBSTORM, "WebStorm 4", "/webstorm/webstorm-4.0.3.icns"),
    WEBSTORM_6_0_3(WEBSTORM, "WebStorm 6", "/webstorm/webstorm-6.0.3.icns"),
    WEBSTORM_9_0_4(WEBSTORM, "WebStorm 9", "/webstorm/webstorm-9.0.4.icns"),
    WEBSTORM_2016_1_3(WEBSTORM, "WebStorm 2016", "/webstorm/webstorm-2016.1.3.icns"),
    WEBSTORM_2020_3_3(WEBSTORM, "WebStorm 2020", "/webstorm/webstorm-2020.3.3.icns", default = true),
    WEBSTORM_2021_2_4(WEBSTORM, "WebStorm 2021", "/webstorm/webstorm-2021.2.4.icns"),
    WEBSTORM_2023_3_8(WEBSTORM, "WebStorm 2023", "/webstorm/webstorm-2023.3.8.icns"),
    WEBSTORM_2024_2_3(WEBSTORM, "WebStorm 2024", "/webstorm/webstorm-2024.2.3.icns"),

    PHPSTORM_2_1_5(PHPSTORM, "PhpStorm 2", "/phpstorm/phpstorm-2.1.5.icns"),
    PHPSTORM_4_0_3(PHPSTORM, "PhpStorm 4", "/phpstorm/phpstorm-4.0.3.icns"),
    PHPSTORM_6_0_4(PHPSTORM, "PhpStorm 6", "/phpstorm/phpstorm-6.0.4.icns"),
    PHPSTORM_2016_1_2(PHPSTORM, "PhpStorm 2016", "/phpstorm/phpstorm-2016.1.2.icns"),
    PHPSTORM_2020_3_3(PHPSTORM, "PhpStorm 2020", "/phpstorm/phpstorm-2020.3.3.icns", default = true),
    PHPSTORM_2021_2_4(PHPSTORM, "PhpStorm 2021", "/phpstorm/phpstorm-2021.2.4.icns"),
    PHPSTORM_2023_3_8(PHPSTORM, "PhpStorm 2023", "/phpstorm/phpstorm-2023.3.8.icns"),
    PHPSTORM_2024_2_3(PHPSTORM, "PhpStorm 2024", "/phpstorm/phpstorm-2024.2.3.icns"),

    RIDER_2017_1_2(RIDER, "Rider 2017.1", "/rider/rider-2017.1.2.icns"),
    RIDER_2017_2_1(RIDER, "Rider 2017.2", "/rider/rider-2017.2.1.icns"),
    RIDER_2017_3_1(RIDER, "Rider 2017.3", "/rider/rider-2017.3.1.icns"),
    RIDER_2020_3_4(RIDER, "Rider 2020", "/rider/rider-2020.3.4.icns", default = true),
    RIDER_2021_2_3(RIDER, "Rider 2021", "/rider/rider-2021.2.3.icns"),
    RIDER_2023_3_6(RIDER, "Rider 2023", "/rider/rider-2023.3.6.icns"),
    RIDER_2024_2_6(RIDER, "Rider 2024", "/rider/rider-2024.2.6.icns"),

    ROVER_2024_1_8(RUST_ROVER, "Rust Rover 2024.1", "/rover/rover-2024.1.8.icns"),
    ROVER_2024_2_3(RUST_ROVER, "Rust Rover 2024.2", "/rover/rover-2024.2.3.icns", default = true),

    RUBY_MINE_4_0_3(RUBY_MINE, "RubyMine 4.0", "/rubymine/rubymine-4.0.3.icns"),
    RUBY_MINE_4_5_4(RUBY_MINE, "RubyMine 4.5", "/rubymine/rubymine-4.5.4.icns"),
    RUBY_MINE_5_0_2(RUBY_MINE, "RubyMine 5.0", "/rubymine/rubymine-5.0.2.icns"),
    RUBY_MINE_5_4_4(RUBY_MINE, "RubyMine 5.4", "/rubymine/rubymine-5.4.4.icns"),
    RUBY_MINE_7_0_5(RUBY_MINE, "RubyMine 7", "/rubymine/rubymine-7.0.5.icns"),
    RUBY_MINE_2016_1_2(RUBY_MINE, "RubyMine 2016", "/rubymine/rubymine-2016.1.2.icns"),
    RUBY_MINE_2020_3_4(RUBY_MINE, "RubyMine 2020", "/rubymine/rubymine-2020.3.4.icns", default = true),
    RUBY_MINE_2021_2_4(RUBY_MINE, "RubyMine 2021", "/rubymine/rubymine-2021.2.4.icns"),
    RUBY_MINE_2023_3_8(RUBY_MINE, "RubyMine 2023", "/rubymine/rubymine-2023.3.8.icns"),
    RUBY_MINE_2024_2_3(RUBY_MINE, "RubyMine 2024", "/rubymine/rubymine-2024.2.3.icns");

    private val previewPath = path.replace(".icns", ".png")

    fun load() = this::class.java.getResourceAsStream(path) ?: error("Failed to load icon from resources: $name")
    fun loadPreview() = IconLoader.getIcon(previewPath, Icons::class.java).let {
        IconUtil.scale(it, null, 128.0f / it.iconWidth)
    }

    companion object {
        val current = entries.filter { it.platform == IconPlatform.CURRENT }
        val default = current.first { it.default }
    }
}
