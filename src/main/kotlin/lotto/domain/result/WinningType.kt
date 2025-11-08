package lotto.domain.result

private fun exactly(number: Int): (MatchResult) -> Boolean =
    { it.matchedCount == number }

enum class WinningType(
    val prizeAmount: Int,
    val label: String,
    private val rule: (MatchResult) -> Boolean
) {
    NONE(0, "", { it.matchedCount < 3 }),
    FIFTH(5_000, "3개 일치 (5,000원)", exactly(3)),
    FOURTH(50_000, "4개 일치 (50,000원)", exactly(4)),
    THIRD(1_500_000, "5개 일치 (1,500,000원)", { it.matchedCount == 5 && !it.bonusMatched }),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)", { it.matchedCount == 5 && it.bonusMatched }),
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원)", exactly(6));

    companion object {
        fun from(result: MatchResult): WinningType =
            entries.firstOrNull { it.rule(result) } ?: NONE
    }
}
