package ru.chimchima

import com.intellij.openapi.util.IconLoader

enum class Icon(val label: String, val path: String) {
    IDEA_11_0_2("IDEA 11.0.2", "/idea/idea-11.0.2.icns"),
    IDEA_12_1_8("IDEA 12.1.8", "/idea/idea-12.1.8.icns"),
    IDEA_14_0_5("IDEA 14.0.5", "/idea/idea-14.0.5.icns"),
    IDEA_2016_1_4("IDEA 2016.1.4", "/idea/idea-2016.1.4.icns"),
    IDEA_2020_3_4("IDEA 2020.3.4", "/idea/idea-2020.3.4.icns"),
    IDEA_2021_2_4("IDEA 2021.2.4", "/idea/idea-2021.2.4.icns"),
    IDEA_2023_3_8("IDEA 2023.3.8", "/idea/idea-2023.3.8.icns"),
    IDEA_2024_2_3("IDEA 2024.2.3", "/idea/idea-2024.2.3.icns");

    private val previewPath = path.replace(".icns", ".png")

    fun load() = this::class.java.getResourceAsStream(path) ?: error("Failed to load icon from resources: $name")
    fun loadPreview() = IconLoader.getIcon(previewPath, Icon::class.java)

    companion object {
        val IDEA_CLASSIC = IDEA_2020_3_4
    }
}
