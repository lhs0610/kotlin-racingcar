package stringcalculator

import java.util.LinkedList
import java.util.Queue

class StringCalculator {
    fun calculate(expression: String?): Int {
        val splits = expression?.split(DELIMITER)
            ?: throw IllegalArgumentException("Invalid input.")

        val queue: Queue<String> = LinkedList(splits)
        var result = queue.poll().toInt()
        while (queue.isNotEmpty()) {
            val operator = Operator.of(queue.poll())
            val operand = queue.poll().toInt()

            result = operator.calculate(result, operand)
        }

        return result
    }

    companion object {
        private const val DELIMITER = " "
    }
}