package lotto.controller

import lotto.view.InputView

class LottoController(
    private val inputView: InputView,
) {
    fun run() {
        val message = inputView.enterMessage()
        println("you entered: $message")
    }
}