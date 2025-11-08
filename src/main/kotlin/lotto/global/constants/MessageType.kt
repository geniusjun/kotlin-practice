package lotto.global.constants

enum class MessageType(val message: String) {
    COST_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_COUNT_MESSAGE("%d개를 구매했습니다."),
    WINNING_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_REQUEST_MESSAGE("보너스 번호를 입력해 주세요.");
}
