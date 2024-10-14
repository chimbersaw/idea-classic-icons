package ru.chimchima

import com.intellij.openapi.components.BaseState
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.Service.Level
import com.intellij.openapi.components.SimplePersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.Row
import com.intellij.ui.dsl.builder.bind
import com.intellij.ui.dsl.builder.panel
import com.intellij.util.application

@Service(Level.APP)
@State(name = "IconSettings", storages = [Storage("iconSettings.xml")])
class IconSettings : SimplePersistentStateComponent<IconState>(IconState()) {
    companion object {
        fun getInstance() = application.getService(IconSettings::class.java)
    }
}

class IconState : BaseState() {
    var currentIcon by enum<Icons>()
    var selectedIcon by enum<Icons>(Icons.default)
}

class IconOptions : BoundConfigurable("Classic Icons Settings"), Configurable.Beta {
    private val settings = IconSettings.getInstance()

    override fun apply() {
        super.apply()
        IconChanger.changeIcon()
    }

    override fun createPanel(): DialogPanel {
        fun createOption(icon: Icons): (Row.() -> Unit) = {
            radioButton("", icon)
            icon(icon.loadPreview())
            label(icon.label)
        }

        return panel {
            buttonsGroup {
                val icons = Icons.current
                val firstHalf = icons.take(icons.size / 2)
                val secondHalf = icons.drop(icons.size / 2)
                firstHalf.zip(secondHalf).forEach {
                    twoColumnsRow(
                        createOption(it.first),
                        createOption(it.second)
                    )
                }
            }.bind(settings.state::selectedIcon)
        }
    }
}
