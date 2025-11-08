package lotto.global.constants

const val ERROR_PREFIX = "[ERROR] "

enum class ErrorMessage(val template: String) {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NUMBER_FORMAT_ERROR("숫자 형식이 아닙니다."),
    INVALID_RANGE_ERROR("올바르지 않은 범위의 숫자입니다."),
    INVALID_UNIT_ERROR("%d원 단위의 숫자만 입력해주세요."),
    NUMBER_DUPLICATE_ERROR("중복되지 않는 숫자를 입력해주세요"),
    INVALID_LOTTO_SIZE_ERROR("%d개의 로또 번호를 입력해주세요"),
    BONUS_NUMBER_DUPLICATE_ERROR("보너스 번호는 입력하신 당첨 번호와 중복되지 않아야 합니다.")
    ;

    fun formatted(vararg args: Any): String {
        return ERROR_PREFIX + template.format(*args)
    }
}