package org.example.global.constants

const val ERROR_PREFIX = "[ERROR] "

enum class ErrorMessage(private val rawMessage: String) {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NUMBER_FORMAT_ERROR("숫자 형식이 아닙니다.")
    ;

    val message: String = ERROR_PREFIX + rawMessage
}