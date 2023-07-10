package stringcalculator.constants

enum class ErrorType(
    val message: String
) {
    INVALID_OPERATOR("Invalid operator symbol."),
    INVALID_INPUT_NULL("Input is not null."),
    INVALID_INPUT_BLANK("Input is not blank.")
}