package lotto.controller

import lotto.view.ui.InputView

class LottoController(
    private val inputView: InputView,
) {
    fun run() {
        val message = inputView.enterMessage()
        println("you entered: $message")
    }
}