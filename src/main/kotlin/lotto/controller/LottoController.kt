package lotto.controller

import lotto.application.LottoService
import lotto.domain.WinningNumbers
import lotto.domain.result.WinningResult
import lotto.global.constants.MessageType.*
import lotto.view.format.LottoFormatter
import lotto.view.format.StatisticsFormatter
import lotto.view.ui.InputView
import lotto.view.ui.OutputView
import lotto.view.util.InputLoop

class LottoController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val lottoService: LottoService,
    private val loop: InputLoop,
) {

    fun play() {
        val cost = askCost()

        val lottos = lottoService.buyLottos(cost)
        showLottos(lottos)

        val winningNumbers = askWinningNumbers()

        val result = WinningResult.of(lottos, winningNumbers)
        printWinningStatistics(result, cost)
    }

    private fun askCost() =
        loop.retryUntilSuccess {
            outputView.printlnMessage(COST_REQUEST_MESSAGE.message)
            val input = inputView.enterMessage()
            lottoService.parseCost(input)
        }

    private fun showLottos(lottos: lotto.domain.Lottos) {
        outputView.printlnMessage(LottoFormatter.lottoCount(lottos.size()))
        outputView.printLottos(lottos)
    }

    private fun askWinningNumbers(): WinningNumbers {
        val winningLotto = loop.retryUntilSuccess {
            outputView.printlnMessage(WINNING_REQUEST_MESSAGE.message)
            val input = inputView.enterMessage()
            lottoService.parseWinningLotto(input)
        }

        val bonus = loop.retryUntilSuccess {
            outputView.printlnMessage(BONUS_REQUEST_MESSAGE.message)
            val input = inputView.enterMessage()
            lottoService.parseBonus(input, winningLotto)
        }

        return WinningNumbers.of(winningLotto, bonus)
    }

    private fun printWinningStatistics(result: WinningResult, cost: lotto.domain.Cost) {
        outputView.printLines(StatisticsFormatter.lines(result, cost))
    }
}
