package stringcalculator.domain

import stringcalculator.constants.ErrorType.INVALID_INPUT_BLANK
import stringcalculator.enums.Operator

class StringCalculator(
    val splitPolicy: SplitPolicy = SpaceSplitPolicy()
) {
    fun calculate(expression: String?): Double {
        require(!expression.isNullOrBlank()) {
            INVALID_INPUT_BLANK.message
        }

        val splits = expression.split(DELIMITER)

        val queue = ArrayDeque(splits)
        var result = queue.removeFirst().toDouble()
        while (queue.isNotEmpty()) {
            val operator = Operator.of(queue.removeFirst())
            val operand = queue.removeFirst().toDouble()

            result = operator.calculate(result, operand)
        }

        return result
    }

    companion object {
        private const val DELIMITER = " "
    }
}