package lotto.view.ui

import lotto.domain.Lottos
import lotto.view.format.LottoFormatter

class OutputView {

    fun printlnMessage(message: String) {
        println(message)
    }

    fun printLottos(lottos: Lottos) {
        printLines(LottoFormatter.lottoLines(lottos))
    }

    fun printLines(lines: Sequence<String>) {
        lines.forEach(::printlnMessage)
    }
}
