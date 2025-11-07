package org.example.global

import org.example.domain.LottoNumber
import org.example.global.constants.ErrorMessage.NUMBER_FORMAT_ERROR

object Parser {

    fun stringToInt(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException(NUMBER_FORMAT_ERROR.template)
    }

    fun stringToNumbers(text: String): List<LottoNumber> {
        return text
            .split(",")
            .map { it.trim() }
            .map { stringToInt(it) }
            .map { LottoNumber.valueOf(it) }
    }

}
