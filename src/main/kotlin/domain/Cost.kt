package org.example.domain

import org.example.global.Parser
import org.example.global.constants.ErrorMessage.INVALID_UNIT_ERROR
import org.example.global.constants.LottoConstants

class Cost private constructor(val price: Int) {

    companion object {
        fun from(message: String): Cost {
            val value = Validator.validate(message)
            return Cost(value)
        }
    }

    val count: Int
        get() = price / LottoConstants.COST_UNIT.value

    private object Validator {

        fun validate(cost: String): Int {
            val value = Parser.stringToInt(cost)
            validateUnit(value)
            return value
        }

        private fun validateUnit(value: Int) {
            if (isNotDivisible(value)) {
                throw IllegalArgumentException(
                    INVALID_UNIT_ERROR
                        .formatted(LottoConstants.COST_UNIT)
                )
            }
        }

        private fun isNotDivisible(value: Int): Boolean {
            return value % LottoConstants.COST_UNIT.value != 0
        }
    }
}
