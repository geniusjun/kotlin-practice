package lotto.view.format

import lotto.domain.Cost
import lotto.domain.result.WinningResult
import lotto.domain.result.WinningType

object StatisticsFormatter {
    private const val HEADER = "당첨 통계"
    private const val DIVIDER = "---"
    private const val YIELD_TEMPLATE = "총 수익률은 %.1f%%입니다."
    private const val COUNT_LINE_FORMAT = "%s - %d개"

    fun formatYield(yieldPercent: Double): String =
        YIELD_TEMPLATE.format(yieldPercent)

    fun formatCountLine(type: WinningType, count: Int): String =
        COUNT_LINE_FORMAT.format(type.label, count)

    /**
     * 최종 출력 라인 모음
     */
    fun lines(result: WinningResult, purchaseCost: Cost): List<String> =
        buildList {
            addAll(headerLines())
            addAll(countLines(result))
            add(yieldLine(result, purchaseCost))
        }

    /**
     * 헤더/구분선
     */
    private fun headerLines(): List<String> =
        listOf(HEADER, DIVIDER)

    /**
     * 등수별 카운트 라인
     */
    private fun countLines(result: WinningResult): List<String> =
        result.displayOrder()
            .map { type -> formatCountLine(type, result.countFor(type)) }

    /**
     * 수익률 라인
     */
    private fun yieldLine(result: WinningResult, purchaseCost: Cost): String {
        val yield = result.yieldPercentage(purchaseCost.price.toLong())
        return formatYield(yield)
    }
}
