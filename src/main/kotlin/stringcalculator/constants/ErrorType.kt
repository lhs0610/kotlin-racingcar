package stringcalculator.constants

enum class ErrorType(
    val message: String
) {
    INVALID_OPERATOR("Invalid operator symbol."),
    INVALID_INPUT_BLANK("Input must be not blank."),
    INVALID_DIVIDE_OPERAND("Cannot be divide by zero."),
    INVALID_EXPRESSION("Invalid expression.")
}