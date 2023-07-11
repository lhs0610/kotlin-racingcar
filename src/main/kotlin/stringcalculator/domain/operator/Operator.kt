package stringcalculator.domain.operator

import stringcalculator.constants.ErrorType.INVALID_DIVIDE_OPERAND
import stringcalculator.constants.ErrorType.INVALID_OPERATOR

enum class Operator(
    private val symbol: String,
    private val operate: (Double, Double) -> Double
) {
    ADD("+", { num1: Double, num2: Double -> num1 + num2}),
    SUBTRACT("-", { num1: Double, num2: Double -> num1 - num2}),
    MULTIPLE("*", { num1: Double, num2: Double -> num1 * num2}),
    DIVIDE("/", { num1: Double, num2: Double ->
        require(num2 != 0.0) {
            INVALID_DIVIDE_OPERAND.message
        }
        num1 / num2
    })
    ;

    fun calculate(num1: Double, num2: Double): Double = operate(num1, num2)

    companion object {
        private val SYMBOL_MAP = values().associateBy { it.symbol }

        fun of(input: String): Operator = SYMBOL_MAP.getOrElse(input) {
            throw IllegalArgumentException(INVALID_OPERATOR.message) 
        }
    }
}