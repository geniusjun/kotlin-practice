package lotto.domain

import lotto.domain.result.MatchResult

class WinningNumbers private constructor(private val winning: Lotto, private val bonus: Bonus) {

    companion object {
        fun of(winning: Lotto, bonus: Bonus): WinningNumbers {
            return WinningNumbers(winning, bonus)
        }
    }

    fun compare(lotto: Lotto): MatchResult {
        val count = lotto.countMatches(winning)
        val bonusMatched = lotto.contains(bonus.value)
        return MatchResult(count, bonusMatched)
    }
}
