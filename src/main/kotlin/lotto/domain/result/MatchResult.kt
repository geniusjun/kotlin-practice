package lotto.domain.result

data class MatchResult(val matchedCount: Int, val bonusMatched: Boolean) {
    companion object {
        fun of(matchedCount: Int, bonusMatched: Boolean): MatchResult =
            MatchResult(matchedCount, bonusMatched)
    }
}
