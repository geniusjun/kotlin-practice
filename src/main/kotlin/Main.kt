import lotto.controller.LottoController
import lotto.view.ui.InputView

fun main() {
    val inputView = InputView()
    val controller = LottoController(inputView)
    controller.run()
}