package component

import enums.Operator

const val INVALID_EXPRESSION = "Invalid Expression"

class MathExpression(str: String?) {
    val numList = ArrayList<Int>()
    val operatorList = ArrayList<Operator>()

    init {
        str ?: throw IllegalArgumentException(INVALID_EXPRESSION)
        val list = str.split(" ")

        for ((index, el) in list.withIndex()) {
            if (index % 2 == 0) {
                numList.add(el.toValidatedNum())
            } else {
                operatorList.add(el.toValidatedOperator())
            }
        }

        require(validateExpression()) {
            INVALID_EXPRESSION
        }
    }

    private fun String.toValidatedNum(): Int {
        return this.toIntOrNull() ?: throw IllegalArgumentException(INVALID_EXPRESSION)
    }

    private fun String.toValidatedOperator(): Operator {
        require(this.length == 1) {
            INVALID_EXPRESSION
        }
        return Operator.of(this)
    }

    private fun validateExpression(): Boolean {
        require(operatorList.size > 0 && operatorList.size + 1 == numList.size) {
            INVALID_EXPRESSION
        }
        return true
    }
}
