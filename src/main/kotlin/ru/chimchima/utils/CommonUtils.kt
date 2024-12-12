package ru.chimchima.utils

import com.intellij.ide.IdeBundle
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ApplicationNamesInfo
import com.intellij.openapi.ui.Messages

@Messages.YesNoResult
fun showRestartDialog(): Int {
    val productName = ApplicationNamesInfo.getInstance().fullProductName
    val title = IdeBundle.message(
        "updates.dialog.title",
        productName
    )

    val action = if (ApplicationManager.getApplication().isRestartCapable) {
        IdeBundle.message("ide.restart.action")
    } else {
        IdeBundle.message("ide.shutdown.action")
    }

    val message = IdeBundle.message(
        "ide.restart.required.message",
        action,
        productName
    )

    return Messages.showYesNoDialog(
        message,
        title,
        action,
        IdeBundle.message("link.cancel"),
        Messages.getQuestionIcon()
    )
}
