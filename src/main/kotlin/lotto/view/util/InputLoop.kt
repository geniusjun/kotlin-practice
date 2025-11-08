package lotto.view.util

import lotto.view.ui.OutputView

class InputLoop(private val out: OutputView) {

    fun <T> retryUntilSuccess(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                out.printlnMessage(e.message ?: "")
            }
        }
    }
}