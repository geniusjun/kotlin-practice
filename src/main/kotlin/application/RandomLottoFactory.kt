package org.example.application

import org.example.domain.Lotto
import org.example.domain.LottoNumber
import org.example.global.constants.LottoConstants.*


class RandomLottoFactory : LottoFactory {
    override fun create(): Lotto {
        val numbers = (MIN_LOTTO_NUMBER.value..MAX_LOTTO_NUMBER.value)
            .shuffled()
            .take(LOTTO_SIZE.value)
            .sorted()
            .map { LottoNumber.valueOf(it) }

        return Lotto.from(numbers)
    }
}
