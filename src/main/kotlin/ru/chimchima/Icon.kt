package ru.chimchima

import com.intellij.util.IconUtil
import ru.chimchima.IconPlatform.*
import ru.chimchima.utils.IconUtils
import javax.swing.ImageIcon
import kotlin.error

enum class Icon(
    val platform: IconPlatform,
    val label: String,
    val path: String,
    val default: Boolean = false
) {
    IDEA_ULTIMATE_11_0_2(INTELLIJ_IDEA, "IDEA Ultimate 11.0.2", "/ideaU/ideaU-11.0.2"),
    IDEA_ULTIMATE_12_1_8(INTELLIJ_IDEA, "IDEA Ultimate 12.1.8", "/ideaU/ideaU-12.1.8"),
    IDEA_ULTIMATE_14_0_5(INTELLIJ_IDEA, "IDEA Ultimate 14.0.5", "/ideaU/ideaU-14.0.5"),
    IDEA_ULTIMATE_2016_1_4(INTELLIJ_IDEA, "IDEA Ultimate 2016", "/ideaU/ideaU-2016.1.4"),
    IDEA_ULTIMATE_2020_3_4(INTELLIJ_IDEA, "IDEA Ultimate 2020", "/ideaU/ideaU-2020.3.4", default = true),
    IDEA_ULTIMATE_2021_2_4(INTELLIJ_IDEA, "IDEA Ultimate 2021", "/ideaU/ideaU-2021.2.4"),
    IDEA_ULTIMATE_2023_3_8(INTELLIJ_IDEA, "IDEA Ultimate 2023", "/ideaU/ideaU-2023.3.8"),
    IDEA_ULTIMATE_2024_2_4(INTELLIJ_IDEA, "IDEA Ultimate 2024", "/ideaU/ideaU-2024.2.4"),
    IDEA_ULTIMATE_2024_2_4_WIN(INTELLIJ_IDEA, "IDEA Ultimate 2024 (win)", "/ideaU/ideaU-2024.2.4w"),

    IDEA_COMMUNITY_11_0_2(INTELLIJ_IDEA, "IDEA Community 11.0.2", "/ideaC/ideaC-11.0.2"),
    IDEA_COMMUNITY_12_1_8(INTELLIJ_IDEA, "IDEA Community 12.1.8", "/ideaC/ideaC-12.1.8"),
    IDEA_COMMUNITY_14_0_5(INTELLIJ_IDEA, "IDEA Community 14.0.5", "/ideaC/ideaC-14.0.5"),
    IDEA_COMMUNITY_2016_1_4(INTELLIJ_IDEA, "IDEA Community 2016", "/ideaC/ideaC-2016.1.4"),
    IDEA_COMMUNITY_2020_3_4(INTELLIJ_IDEA, "IDEA Community 2020", "/ideaC/ideaC-2020.3.4"),
    IDEA_COMMUNITY_2021_2_4(INTELLIJ_IDEA, "IDEA Community 2021", "/ideaC/ideaC-2021.2.4"),
    IDEA_COMMUNITY_2023_3_8(INTELLIJ_IDEA, "IDEA Community 2023", "/ideaC/ideaC-2023.3.8"),
    IDEA_COMMUNITY_2024_2_4(INTELLIJ_IDEA, "IDEA Community 2024", "/ideaC/ideaC-2024.2.4"),
    IDEA_COMMUNITY_2024_2_4_WIN(INTELLIJ_IDEA, "IDEA Community 2024 (win)", "/ideaC/ideaC-2024.2.4w"),

    PYCHARM_PROFESSIONAL_1_1_1(PYCHARM, "PyCharm 1.1.1", "/pycharmP/pycharmP-1.1.1"),
    PYCHARM_PROFESSIONAL_2_5_2(PYCHARM, "PyCharm 2.5.2", "/pycharmP/pycharmP-2.5.2"),
    PYCHARM_PROFESSIONAL_2016_1_5(PYCHARM, "PyCharm 2016", "/pycharmP/pycharmP-2016.1.5"),
    PYCHARM_PROFESSIONAL_2020_3_5(PYCHARM, "PyCharm 2020", "/pycharmP/pycharmP-2020.3.5", default = true),
    PYCHARM_PROFESSIONAL_2021_2_4(PYCHARM, "PyCharm 2021", "/pycharmP/pycharmP-2021.2.4"),
    PYCHARM_PROFESSIONAL_2023_3_7(PYCHARM, "PyCharm 2023", "/pycharmP/pycharmP-2023.3.7"),
    PYCHARM_PROFESSIONAL_2024_2_4(PYCHARM, "PyCharm 2024", "/pycharmP/pycharmP-2024.2.4"),
    PYCHARM_PROFESSIONAL_2024_2_4_WIN(PYCHARM, "PyCharm 2024 (win)", "/pycharmP/pycharmP-2024.2.4w"),

    PYCHARM_COMMUNITY_3_0_3(PYCHARM, "PyCharm Community 3.0.3", "/pycharmC/pycharmC-3.0.3"),
    PYCHARM_COMMUNITY_2016_3_6(PYCHARM, "PyCharm Community 2016", "/pycharmC/pycharmC-2016.3.6"),
    PYCHARM_COMMUNITY_2017_1_8(PYCHARM, "PyCharm Community 2017", "/pycharmC/pycharmC-2017.1.8"),
    PYCHARM_COMMUNITY_2020_3_5(PYCHARM, "PyCharm Community 2020", "/pycharmC/pycharmC-2020.3.5"),
    PYCHARM_COMMUNITY_2021_2_4(PYCHARM, "PyCharm Community 2021", "/pycharmC/pycharmC-2021.2.4"),
    PYCHARM_COMMUNITY_2023_3_7(PYCHARM, "PyCharm Community 2023", "/pycharmC/pycharmC-2023.3.7"),
    PYCHARM_COMMUNITY_2024_2_4(PYCHARM, "PyCharm Community 2024", "/pycharmC/pycharmC-2024.2.4"),
    PYCHARM_COMMUNITY_2024_2_4_WIN(PYCHARM, "PyCharm Community 2024 (win)", "/pycharmC/pycharmC-2024.2.4w"),

    CLION_1_1_2(CLION, "CLion 1.1.2", "/clion/clion-1.1.2"),
    CLION_2016_1_4(CLION, "CLion 2016", "/clion/clion-2016.1.4"),
    CLION_2020_3_4(CLION, "CLion 2020", "/clion/clion-2020.3.4", default = true),
    CLION_2021_2_4(CLION, "CLion 2021", "/clion/clion-2021.2.4"),
    CLION_2023_3_6(CLION, "CLion 2023", "/clion/clion-2023.3.6"),
    CLION_2024_2_3(CLION, "CLion 2024", "/clion/clion-2024.2.3"),
    CLION_2024_2_3_WIN(CLION, "CLion 2024 (win)", "/clion/clion-2024.2.3w"),

    GOLAND_2017_3_5(GOLAND, "GoLand 2017", "/goland/goland-2017.3.5"),
    GOLAND_2019_2_5(GOLAND, "GoLand 2019", "/goland/goland-2019.2.5"),
    GOLAND_2020_3_5(GOLAND, "GoLand 2020", "/goland/goland-2020.3.5", default = true),
    GOLAND_2021_2_5(GOLAND, "GoLand 2021", "/goland/goland-2021.2.5"),
    GOLAND_2023_3_8(GOLAND, "GoLand 2023", "/goland/goland-2023.3.8"),
    GOLAND_2024_2_3(GOLAND, "GoLand 2024", "/goland/goland-2024.2.3"),
    GOLAND_2024_2_3_WIN(GOLAND, "GoLand 2024 (win)", "/goland/goland-2024.2.3w"),

    WEBSTORM_1_0_2(WEBSTORM, "WebStorm 1.0.2", "/webstorm/webstorm-1.0.2"),
    WEBSTORM_4_0_3(WEBSTORM, "WebStorm 4.0.3", "/webstorm/webstorm-4.0.3"),
    WEBSTORM_6_0_3(WEBSTORM, "WebStorm 6.0.3", "/webstorm/webstorm-6.0.3"),
    WEBSTORM_9_0_4(WEBSTORM, "WebStorm 9.0.4", "/webstorm/webstorm-9.0.4"),
    WEBSTORM_2016_1_3(WEBSTORM, "WebStorm 2016", "/webstorm/webstorm-2016.1.3"),
    WEBSTORM_2020_3_3(WEBSTORM, "WebStorm 2020", "/webstorm/webstorm-2020.3.3", default = true),
    WEBSTORM_2021_2_4(WEBSTORM, "WebStorm 2021", "/webstorm/webstorm-2021.2.4"),
    WEBSTORM_2023_3_8(WEBSTORM, "WebStorm 2023", "/webstorm/webstorm-2023.3.8"),
    WEBSTORM_2024_2_4(WEBSTORM, "WebStorm 2024", "/webstorm/webstorm-2024.2.4"),
    WEBSTORM_2024_2_4_WIN(WEBSTORM, "WebStorm 2024 (win)", "/webstorm/webstorm-2024.2.4w"),

    PHPSTORM_2_1_5(PHPSTORM, "PhpStorm 2.1.5", "/phpstorm/phpstorm-2.1.5"),
    PHPSTORM_4_0_3(PHPSTORM, "PhpStorm 4.0.3", "/phpstorm/phpstorm-4.0.3"),
    PHPSTORM_6_0_4(PHPSTORM, "PhpStorm 6.0.4", "/phpstorm/phpstorm-6.0.4"),
    PHPSTORM_2016_1_2(PHPSTORM, "PhpStorm 2016", "/phpstorm/phpstorm-2016.1.2"),
    PHPSTORM_2020_3_3(PHPSTORM, "PhpStorm 2020", "/phpstorm/phpstorm-2020.3.3", default = true),
    PHPSTORM_2021_2_4(PHPSTORM, "PhpStorm 2021", "/phpstorm/phpstorm-2021.2.4"),
    PHPSTORM_2023_3_8(PHPSTORM, "PhpStorm 2023", "/phpstorm/phpstorm-2023.3.8"),
    PHPSTORM_2024_2_4(PHPSTORM, "PhpStorm 2024", "/phpstorm/phpstorm-2024.2.4"),
    PHPSTORM_2024_2_4_WIN(PHPSTORM, "PhpStorm 2024 (win)", "/phpstorm/phpstorm-2024.2.4w"),

    RIDER_2017_1_2(RIDER, "Rider 2017.1", "/rider/rider-2017.1.2"),
    RIDER_2017_2_1(RIDER, "Rider 2017.2", "/rider/rider-2017.2.1"),
    RIDER_2017_3_1(RIDER, "Rider 2017.3", "/rider/rider-2017.3.1"),
    RIDER_2020_3_4(RIDER, "Rider 2020", "/rider/rider-2020.3.4", default = true),
    RIDER_2021_2_3(RIDER, "Rider 2021", "/rider/rider-2021.2.3"),
    RIDER_2023_3_6(RIDER, "Rider 2023", "/rider/rider-2023.3.6"),
    RIDER_2024_2_7(RIDER, "Rider 2024", "/rider/rider-2024.2.7"),
    RIDER_2024_2_7_WIN(RIDER, "Rider 2024 (win)", "/rider/rider-2024.2.7w"),

    RUST_ROVER_2024_1_8(RUST_ROVER, "Rust Rover 2024.1", "/rover/rover-2024.1.8"),
    RUST_ROVER_2024_1_8_WIN(RUST_ROVER, "Rust Rover 2024.1 (win)", "/rover/rover-2024.1.8w", default = true),
    RUST_ROVER_2024_2_4(RUST_ROVER, "Rust Rover 2024.2", "/rover/rover-2024.2.4"),
    RUST_ROVER_2024_2_4_WIN(RUST_ROVER, "Rust Rover 2024.2 (win)", "/rover/rover-2024.2.4w"),

    RUBY_MINE_4_0_3(RUBY_MINE, "RubyMine 4.0.3", "/rubymine/rubymine-4.0.3"),
    RUBY_MINE_4_5_4(RUBY_MINE, "RubyMine 4.5.4", "/rubymine/rubymine-4.5.4"),
    RUBY_MINE_5_0_2(RUBY_MINE, "RubyMine 5.0.2", "/rubymine/rubymine-5.0.2"),
    RUBY_MINE_5_4_4(RUBY_MINE, "RubyMine 5.4.4", "/rubymine/rubymine-5.4.4"),
    RUBY_MINE_7_0_5(RUBY_MINE, "RubyMine 7.0.5", "/rubymine/rubymine-7.0.5"),
    RUBY_MINE_2016_1_2(RUBY_MINE, "RubyMine 2016", "/rubymine/rubymine-2016.1.2"),
    RUBY_MINE_2020_3_4(RUBY_MINE, "RubyMine 2020", "/rubymine/rubymine-2020.3.4", default = true),
    RUBY_MINE_2021_2_4(RUBY_MINE, "RubyMine 2021", "/rubymine/rubymine-2021.2.4"),
    RUBY_MINE_2023_3_8(RUBY_MINE, "RubyMine 2023", "/rubymine/rubymine-2023.3.8"),
    RUBY_MINE_2024_2_4(RUBY_MINE, "RubyMine 2024", "/rubymine/rubymine-2024.2.4"),
    RUBY_MINE_2024_2_4_WIN(RUBY_MINE, "RubyMine 2024 (win)", "/rubymine/rubymine-2024.2.4w");

    private val filename = path.substringAfterLast('/')

    private fun resourceLoadFailed(): Nothing = error("Failed to load icon from resources: $name")
    private fun path(scaled: Boolean, extension: String) = "$path/$filename${if (scaled) "-scaled" else ""}.$extension"
    private fun icnsPath(scaled: Boolean) = path(scaled, "icns")
    private fun icoPath(scaled: Boolean) = path(scaled, "ico")

    fun loadIcns(scaled: Boolean) = icnsPath(scaled).let {
        this::class.java.getResourceAsStream(it) ?: resourceLoadFailed()
    }

    fun loadIco(scaled: Boolean) = icoPath(scaled).let {
        this::class.java.getResourceAsStream(it) ?: resourceLoadFailed()
    }

    fun loadImage(scaled: Boolean) = IconUtils.getImageFromIcns(loadIcns(scaled).use { it.readBytes() })

    fun loadPreviewIcon(scaled: Boolean) = loadImage(scaled).let {
        val icon = ImageIcon(it)
        IconUtil.scale(icon, null, 128.0f / icon.iconWidth)
    }

    companion object {
        val current = entries.filter { it.platform == IconPlatform.CURRENT }
        val default = current.first { it.default }
    }
}
