package lotto.controller

import lotto.application.LottoService
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
        val message = inputView.enterMessage()
        println("you entered: $message")
    }
}