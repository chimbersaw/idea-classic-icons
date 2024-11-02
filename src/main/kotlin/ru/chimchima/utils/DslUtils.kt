package ru.chimchima.utils

import com.intellij.ui.dsl.builder.AlignY
import com.intellij.ui.dsl.builder.Panel
import com.intellij.ui.dsl.builder.Row
import com.intellij.ui.dsl.builder.RowLayout
import com.intellij.ui.dsl.gridLayout.UnscaledGaps
import ru.chimchima.IconPlatform

private fun deluluGap(platform: IconPlatform): UnscaledGaps {
    val gap = when (platform) {
        IconPlatform.INTELLIJ_IDEA, IconPlatform.PYCHARM -> 20
        else -> 60
    }

    return UnscaledGaps(0, 0, 0, gap)
}

fun Panel.twoColumns(platform: IconPlatform, column1: (Row.() -> Unit)?, column2: (Row.() -> Unit)?): Row {
    return row {
        panel {
            row {
                column1?.invoke(this) ?: cell()
            }
        }.align(AlignY.TOP).customize(deluluGap(platform))
        panel {
            row {
                column2?.invoke(this) ?: cell()
            }
        }.align(AlignY.TOP)
    }.layout(RowLayout.PARENT_GRID)
}
