package lotto.domain

import lotto.global.constants.ErrorMessage


class Bonus private constructor(val value: LottoNumber) {
    companion object {
        fun of(bonus: LottoNumber, winning: Lotto): Bonus {
            Validator.validateDuplicate(bonus, winning)
            return Bonus(bonus)
        }
    }

    private object Validator {
        fun validateDuplicate(bonus: LottoNumber, winning: Lotto) {
            if (isDuplicated(bonus, winning)) {
                throw IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR.template)
            }
        }

        private fun isDuplicated(bonus: LottoNumber, winning: Lotto): Boolean {
            return winning.contains(bonus)
        }
    }
}
