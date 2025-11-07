package org.example.view

import org.example.global.constants.ErrorMessage

class InputView {

    fun enterMessage(): String {
        val input = readLine() ?: ""
        return validateBlank(input)
    }

    private fun validateBlank(message: String): String {
        if (message.isBlank()) {
            throw IllegalArgumentException(ErrorMessage.BLANK_INPUT_ERROR.message)
        }
        return message
    }
}
