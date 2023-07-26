package enums

import java.util.function.BinaryOperator

const val INVALID_EXPRESSION = "Invalid Expression"

enum class Operator(val operator: String) : BinaryOperator<Int> {
    PLUS("+") {
        override fun apply(t: Int, u: Int): Int {
            return t + u
        }
    },
    MINUS("-") {
        override fun apply(t: Int, u: Int): Int {
            return t - u
        }
    },
    MULTIPLY("*") {
        override fun apply(t: Int, u: Int): Int {
            return t * u
        }
    },
    DIVIDE("/") {
        override fun apply(t: Int, u: Int): Int {
            return t / u
        }
    };

    companion object {
        fun of(operator: String): Operator {
            return values().firstOrNull {
                it.operator == operator
            } ?: throw IllegalArgumentException(INVALID_EXPRESSION)
        }
    }
}
