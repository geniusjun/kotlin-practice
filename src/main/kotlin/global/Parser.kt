package org.example.global

import org.example.global.constants.ErrorMessage

object Parser {

    fun stringToInt(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR.message)
    }

}
