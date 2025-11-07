package org.example

import org.example.controller.LottoController
import org.example.view.InputView

fun main() {
    val inputView = InputView()
    val controller = LottoController(inputView)
    controller.run()
}