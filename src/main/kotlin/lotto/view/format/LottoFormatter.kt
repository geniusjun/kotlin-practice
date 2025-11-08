package lotto.view.format

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.global.constants.MessageType.LOTTO_COUNT_MESSAGE

object LottoFormatter {
    private const val SEPARATOR = ", "
    private const val PREFIX = "["
    private const val POSTFIX = "]"

    fun lottoCount(count: Int): String =
        LOTTO_COUNT_MESSAGE.message.format(count)

    /**
     * 로또 여러 장을 문자열 리스트로 반환한다.
     */
    fun lottoLines(lottos: Lottos): List<String> =
        lottos.asList().map { lottoLine(it) }

    /**
     * 한 장을 "[1, 8, 11, 31, 41, 42]" 형태로 정렬하여 반환한다.
     */
    private fun lottoLine(lotto: Lotto): String =
        lotto.asList()
            .map { it.value }
            .joinToString(SEPARATOR, PREFIX, POSTFIX)
}
