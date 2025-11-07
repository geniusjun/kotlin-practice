package org.example.global.constants

const val ERROR_PREFIX = "[ERROR] "

enum class ErrorMessage(private val rawMessage: String) {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NUMBER_FORMAT_ERROR("숫자 형식이 아닙니다."),
    INVALID_RANGE_ERROR("올바르지 않은 범위의 숫자입니다."),
    INVALID_UNIT_ERROR("%d원 단위의 숫자만 입력해주세요.")
    ;

    val message: String = ERROR_PREFIX + rawMessage
}