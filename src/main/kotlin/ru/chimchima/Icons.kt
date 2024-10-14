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
    CLION_2024_2_2(CLION, "CLion 2024", "/clion/clion-2024.2.2.icns");

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
