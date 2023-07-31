package racingcar.validator

object TotalStepArgumentValidator : InputArgumentValidator {
    private const val MINIMUM_INPUT_VALUE = 1

    override fun validate(input: String): Boolean {
        if (!checkStringIsNumeric(input)) {
            return false
        }

        return checkValue(input.toInt())
    }

    private fun checkStringIsNumeric(input: String): Boolean {
        val toIntOrNull = input.toIntOrNull()
        return toIntOrNull is Int
    }

    private fun checkValue(input: Int): Boolean {
        return input >= MINIMUM_INPUT_VALUE
    }
}
