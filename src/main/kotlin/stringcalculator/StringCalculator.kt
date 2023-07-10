package stringcalculator

import stringcalculator.constants.ErrorType.INVALID_INPUT_BLANK
import stringcalculator.constants.ErrorType.INVALID_INPUT_NULL
import stringcalculator.enums.Operator
import java.util.*

class StringCalculator {
    fun calculate(expression: String?): Int {
        val splits = expression?.split(DELIMITER)
            ?: throw IllegalArgumentException(INVALID_INPUT_NULL.message)

        validateEmpty(expression)

        val queue: Queue<String> = LinkedList(splits)
        var result = queue.poll().toInt()
        while (queue.isNotEmpty()) {
            val operator = Operator.of(queue.poll())
            val operand = queue.poll().toInt()

            result = operator.calculate(result, operand)
        }

        return result
    }

    private fun validateEmpty(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException(INVALID_INPUT_BLANK.message)
        }
    }

    companion object {
        private const val DELIMITER = " "
    }
}