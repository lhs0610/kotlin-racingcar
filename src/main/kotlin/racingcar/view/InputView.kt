package racingcar.view

import racingcar.constant.Message
import racingcar.model.dto.UserInputDto

object InputView {

    private const val MININUM_INPUT_VALUE = 1

    fun getUserInput(): UserInputDto {
        val quantity = getCLIInput(Message.INPUT_PARAMETER_QUANTITY.message)
        val totalStep = getCLIInput(Message.INPUT_PARAMETER_TOTAL_STEP.message)

        return UserInputDto(quantity.toInt(), totalStep.toInt())
    }

    private fun getCLIInput(message: String): String {
        println(message)
        var input = readln()
        while(!validateInput(input)) {
            input = readln()
        }
        return input
    }

    private fun validateInput(input: String): Boolean {
        if (!checkStringIsNumeric(input)) {
            println(Message.INVALID_INPUT_FORTMAT.message)
            return false
        }

        if (!checkValue(input.toInt())) {
            println(Message.INVALID_INPUT_VALUE.message)
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