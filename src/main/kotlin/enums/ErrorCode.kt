package enums

enum class ErrorCode(var code: String) {
    //input errors
    ERROR_EXPRESSION_NOT_NULL_OR_BLANK("E001"),
    ERROR_NOT_ALLOWED_SYMBOL("E002"),
    //logical errors
    ERROR_DIVIDER_CANNOT_ZERO("E101")
}