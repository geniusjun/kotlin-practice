package lotto.application

import lotto.domain.Lotto

fun interface LottoFactory {
    fun create(): Lotto
}
