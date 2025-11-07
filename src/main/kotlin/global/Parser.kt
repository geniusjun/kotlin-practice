package org.example.global

import org.example.domain.LottoNumber
import org.example.global.constants.ErrorMessage

object Parser {

    fun stringToInt(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR.message)
    }
    
    fun stringToNumbers(text: String): List<LottoNumber> {
        return text
            .split(",")
            .map { it.trim() }
            .map { stringToInt(it) }
            .map { LottoNumber.valueOf(it) }
    }

}
