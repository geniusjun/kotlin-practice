package org.example.application

import org.example.domain.Lotto

fun interface LottoFactory {
    fun create(): Lotto
}
