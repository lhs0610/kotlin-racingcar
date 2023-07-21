package racingcar.view

import racingcar.constant.Message
import racingcar.domain.StringSplitter
import racingcar.model.UserInput

object InputView {

    private const val MININUM_INPUT_VALUE = 1
    private const val BLANK = ""

    fun getUserInput(): UserInput {
        val entries = getCLIEntryInput(Message.INPUT_PARAMETER_ENTRY.message)
        val totalStep = getCLINumberInput(Message.INPUT_PARAMETER_TOTAL_STEP.message)

        return UserInput(entries, totalStep.toInt())
    }

    private fun getCLIEntryInput(message: String): List<String> {
        println(message)
        var input = readln()
        while(!validateEntryInput(input)) {
            println(Message.INVALID_INPUT_FORTMAT_CANNOT_SPLIT.message)
            input = readln()
        }
        return StringSplitter.split(input)
    }

    private fun validateEntryInput(input: String): Boolean {
        val split = StringSplitter.split(input)
        return split.none { it == BLANK }
    }

    private fun getCLINumberInput(message: String): String {
        println(message)
        var input = readln()
        while(!validateNumberInput(input)) {
            input = readln()
        }
        return input
    }

    private fun validateNumberInput(input: String): Boolean {
        if (!checkStringIsNumeric(input)) {
            println(Message.INVALID_INPUT_FORTMAT_NOT_INTEGER.message)
            return false
        }

        if (!checkValue(input.toInt())) {
            println(Message.INVALID_INPUT_VALUE_CANNOT_LOWER_THEN_ZERO.message)
            return false
        }

        return true
    }

    private fun checkStringIsNumeric(input: String): Boolean {
        val toIntOrNull = input.toIntOrNull()
        return toIntOrNull is Int
    }

    private fun checkValue(input: Int): Boolean {
        return input >= MININUM_INPUT_VALUE
    }
}
