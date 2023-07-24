package racingcar.converter

import racingcar.constant.Message
import racingcar.model.TotalStepInput

class TotalStepArgumentResolver : InputArgumentResolver<TotalStepInput> {

    override fun validate(input: String): Boolean {
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
        return input >= MINIMUM_INPUT_VALUE
    }

    override fun resolve(input: String): TotalStepInput {
        return TotalStepInput(input.toInt())
    }

    companion object {
        private const val MINIMUM_INPUT_VALUE = 1
    }
}
