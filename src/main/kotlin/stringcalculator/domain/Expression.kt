package stringcalculator.domain

import stringcalculator.constants.ErrorType.INVALID_EXPRESSION
import stringcalculator.enums.Operator

class Expression (
    private val operators: ArrayDeque<Operator>,
    private val operands: ArrayDeque<Operand>
) {
    init {
        require(operands.size == operators.size - 1) {
            INVALID_EXPRESSION.message
        }
    }

    fun calculate(): Double {
        val firstOperand = operands.removeFirst()
        var result = firstOperand.value
        while(operands.isNotEmpty()) {
            val operator = operators.removeFirst()
            val operand = operands.removeFirst()
            result = operator.calculate(result, operand.value)
        }

        return result
    }
}