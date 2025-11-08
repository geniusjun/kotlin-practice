package lotto.view

import lotto.global.constants.ErrorMessage.BLANK_INPUT_ERROR

class InputView {

    fun enterMessage(): String {
        val input = readLine() ?: ""
        return validateBlank(input)
    }

    private fun validateBlank(message: String): String {
        if (message.isBlank()) {
            throw IllegalArgumentException(BLANK_INPUT_ERROR.template)
        }
        return message
    }
}
