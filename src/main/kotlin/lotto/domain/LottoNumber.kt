package lotto.domain

import lotto.global.constants.ErrorMessage.INVALID_RANGE_ERROR
import lotto.global.constants.LottoConstants

class LottoNumber private constructor(val value: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as LottoNumber
        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        fun valueOf(value: Int): LottoNumber {
            Validator.validate(value)
            return LottoNumber(value)
        }
    }

    private object Validator {

        fun validate(value: Int) {
            validateInvalidRange(value)
        }

        private fun validateInvalidRange(value: Int) {
            if (isInvalidRange(value)) {
                throw IllegalArgumentException(INVALID_RANGE_ERROR.template)
            }
        }

        private fun isInvalidRange(value: Int): Boolean {
            return value < LottoConstants.MIN_LOTTO_NUMBER.value ||
                    value > LottoConstants.MAX_LOTTO_NUMBER.value
        }
    }
}
