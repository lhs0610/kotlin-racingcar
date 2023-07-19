package calculator.enums

enum class Operator(
    private val symbol: String,
    private val operate: (Double, Double) -> Double
) {
    PLUS("+", { operand1, operand2 -> operand1 + operand2 }),
    MINUS("-", { operand1, operand2 -> operand1 - operand2 }),
    TIMES("*", { operand1, operand2 -> operand1 * operand2 }),
    DIV("/", { operand1, operand2 ->
        require(operand2 != 0.0) {
            throw IllegalArgumentException(Error.INVALID_DENOMINATOR.message)
        }
        operand1 / operand2
    })
    ;

    fun calculate(num1: Double, num2: Double): Double = operate(num1, num2)

    companion object {
        private val SYMBOL_MAP = values().associateBy {
            it.symbol
        }

        fun of(input: String): Operator = SYMBOL_MAP.getOrElse(input) {
            throw IllegalArgumentException(Error.INVALID_OPERATOR.message)
        }
    }
}
