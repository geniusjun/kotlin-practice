package lotto.domain.result

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.WinningNumbers

class WinningResult private constructor() {

    private val countsByType: MutableMap<WinningType, Int> = mutableMapOf()

    init {
        WinningType.entries.forEach { countsByType[it] = 0 }
    }

    companion object {
        private val DISPLAY_ORDER = listOf(
            WinningType.FIFTH,
            WinningType.FOURTH,
            WinningType.THIRD,
            WinningType.SECOND,
            WinningType.FIRST,
        )

        fun of(purchased: Lottos, drawn: WinningNumbers): WinningResult {
            val result = WinningResult()
            purchased.asSequence()
                .map { decideType(it, drawn) }
                .forEach { result.increment(it) }
            return result
        }

        private fun decideType(lotto: Lotto, drawn: WinningNumbers): WinningType =
            WinningType.from(drawn.compare(lotto))
    }

    private fun increment(type: WinningType) {
        countsByType[type] = countsByType.getValue(type) + 1
    }

    fun countFor(type: WinningType): Int = countsByType[type] ?: 0

    fun totalPrizeAmount(): Long =
        countsByType.entries.sumOf { (type, count) ->
            type.prizeAmount.toLong() * count
        }

    fun yieldPercentage(totalPurchaseAmount: Long): Double {
        return totalPrizeAmount() / totalPurchaseAmount.toDouble() * 100.0
    }

    fun displayOrder(): List<WinningType> = DISPLAY_ORDER
}
