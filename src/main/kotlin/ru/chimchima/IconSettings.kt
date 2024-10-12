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
    var currentIcon by enum<Icon>()
    var selectedIcon by enum<Icon>(Icon.IDEA_CLASSIC)
}

class IconOptions : BoundConfigurable("Classic Icons Settings"), Configurable.Beta {
    private val settings = IconSettings.getInstance()

    override fun apply() {
        super.apply()
        IconChanger.changeIcon()
    }

    override fun createPanel(): DialogPanel {
        return panel {
            buttonsGroup {
                Icon.entries.forEach {
                    row {
                        radioButton("", it)
                        icon(it.loadPreview())
                        label(it.label)
                    }
                }
            }.bind(settings.state::selectedIcon)
        }
    }
}
