package stringcalculator.enums

import stringcalculator.constants.ErrorType

enum class Operator(
    private val symbol: String,
    private val operate: (Int, Int) -> Int
) {
    ADD("+", {num1: Int, num2: Int -> num1 + num2}),
    SUBTRACT("-", { num1: Int, num2: Int -> num1 - num2}),
    MULTIPLE("*", { num1: Int, num2: Int -> num1 * num2}),
    DIVIDE("/", { num1: Int, num2: Int -> num1 / num2})
    ;

    fun calculate(num1: Int, num2: Int): Int = operate(num1, num2)

    companion object {
        fun of(input: String): Operator {
            return values().firstOrNull { operator -> operator.symbol == input }
                ?: throw IllegalArgumentException(ErrorType.INVALID_OPERATOR.message)
        }
    }
}