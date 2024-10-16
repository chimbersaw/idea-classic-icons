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
    private val iconChanger = IconChanger.getInstance()

    override fun apply() {
        super.apply()
        iconChanger.changeIcon()
    }

    override fun createPanel(): DialogPanel {
        fun Icons.createOption(): (Row.() -> Unit) = {
            radioButton("", this@createOption)
            icon(this@createOption.loadIcon())
            label(this@createOption.label)
        }

        return panel {
            buttonsGroup {
                val icons: MutableList<Icons?> = Icons.current.toMutableList()
                if (icons.size % 2 == 1) icons.add(null)
                var firstHalf = icons.take(icons.size / 2)
                var secondHalf = icons.drop(icons.size / 2)
                firstHalf.zip(secondHalf).forEach {
                    twoColumnsRow(
                        it.first?.createOption(),
                        it.second?.createOption()
                    )
                }
            }.bind(settings.state::selectedIcon)
        }
    }
}
