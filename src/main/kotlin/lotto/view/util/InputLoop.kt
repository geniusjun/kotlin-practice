package lotto.view.util

import lotto.global.constants.ERROR_PREFIX
import lotto.view.ui.OutputView

class InputLoop(private val out: OutputView) {

    fun <T> retryUntilSuccess(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                out.printlnMessage((ERROR_PREFIX + e.message) ?: "")
            }
        }
    }
}