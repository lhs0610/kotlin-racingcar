package calculator.utils

import calculator.enums.Error.CANNOT_BLANK_INPUT_FORMULA
import calculator.enums.Error.INVALID_TYPE_CAST_EXCEPTION

private const val WHITESPACE = " "

fun requireNullOrEmpty(formula: String?) {
    require(formula != null && formula.isNotBlank()) {
        throw IllegalArgumentException(CANNOT_BLANK_INPUT_FORMULA.message)
    }
}

fun splitByWhiteSpace(formula: String) = formula.split(WHITESPACE)

fun toDouble(str: String): Double =
    try {
        str.toDouble()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(INVALID_TYPE_CAST_EXCEPTION.message)
    }
