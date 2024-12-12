package ru.chimchima

import com.intellij.openapi.components.*
import com.intellij.openapi.components.Service.Level
import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.Row
import com.intellij.ui.dsl.builder.bind
import com.intellij.ui.dsl.builder.bindSelected
import com.intellij.ui.dsl.builder.panel
import com.intellij.util.application
import ru.chimchima.utils.twoColumns

@Service(Level.APP)
@State(name = "IconSettings", storages = [Storage("iconSettings.xml", roamingType = RoamingType.PER_OS)])
class IconSettings : SimplePersistentStateComponent<IconState>(IconState()) {
    companion object {
        fun getInstance() = application.getService(IconSettings::class.java)
    }
}

class IconState : BaseState() {
    var selectedIcon by enum<Icon>(Icon.default)
    var macStyledIcons by property(false)
}

class IconOptions : BoundConfigurable("Classic Icons Settings"), Configurable.Beta {
    private val settings = IconSettings.getInstance()
    private val iconChanger = IconChanger.getInstance()

    override fun apply() {
        if (iconChanger.canChange()) {
            super.apply()
            iconChanger.changeIcon()
        }
    }

    override fun createPanel(): DialogPanel {
        fun Icon.createOption(): (Row.() -> Unit) = {
            radioButton("", this@createOption)
            icon(this@createOption.loadPreviewIcon(scaled = false))
            label(this@createOption.label)
        }

        return panel {
            row {
                checkBox("Use macOS icon appearance")
                    .comment("Enable this for smaller and compact icons.")
                    .bindSelected(settings.state::macStyledIcons)
            }
            buttonsGroup {
                val icons: MutableList<Icon?> = Icon.current.toMutableList()
                if (icons.size % 2 == 1) icons.add(null)
                var firstHalf = icons.take(icons.size / 2)
                var secondHalf = icons.drop(icons.size / 2)
                firstHalf.zip(secondHalf).forEach {
                    twoColumns(
                        IconPlatform.CURRENT,
                        it.first?.createOption(),
                        it.second?.createOption()
                    )
                }
            }.bind(settings.state::selectedIcon)
        }
    }
}
