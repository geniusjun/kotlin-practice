package org.example.controller

import org.example.view.InputView

class LottoController(
    private val inputView: InputView,
) {
    fun run() {
        val message = inputView.enterMessage()
        println("you entered: $message")
    }
}