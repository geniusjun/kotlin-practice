package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.global.constants.LottoConstants.*


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
