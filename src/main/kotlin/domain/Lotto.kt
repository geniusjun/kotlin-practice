package org.example.domain

import org.example.global.constants.ErrorMessage.INVALID_LOTTO_SIZE_ERROR
import org.example.global.constants.ErrorMessage.NUMBER_DUPLICATE_ERROR
import org.example.global.constants.LottoConstants.LOTTO_SIZE

class Lotto private constructor(numbers: List<LottoNumber>) {

    private val numbers: List<LottoNumber> = numbers.toList()   // 불변 복사

    companion object {
        fun from(numbers: List<LottoNumber>): Lotto {
            Validator.validate(numbers)
            return Lotto(numbers)
        }
    }

    fun contains(n: LottoNumber): Boolean {
        return numbers.contains(n)
    }

    fun countMatches(other: Lotto): Int {
        return numbers.count { other.contains(it) }
    }

    fun asList(): List<LottoNumber> = numbers

    private object Validator {

        fun validate(numbers: List<LottoNumber>) {
            validateDuplicate(numbers)
            validateLottoSize(numbers)
        }

        private fun validateDuplicate(numbers: List<LottoNumber>) {
            if (isDuplicated(numbers)) {
                throw IllegalArgumentException(NUMBER_DUPLICATE_ERROR.template)
            }
        }

        private fun isDuplicated(numbers: List<LottoNumber>): Boolean {
            return numbers.toSet().size != numbers.size
        }

        private fun validateLottoSize(numbers: List<LottoNumber>) {
            if (numbers.size != LOTTO_SIZE.value) {
                throw IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR.formatted(LOTTO_SIZE))
            }
        }
    }
}
