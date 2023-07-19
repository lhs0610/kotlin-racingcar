package calculator.utils

import calculator.enums.Operator

fun multipleCalculate(formula: String): Double {
    requireNullOrEmpty(formula)
    val trimFormula = splitByWhiteSpace(formula)
    var answer = toDouble(trimFormula[0])
    for (i in 1 until trimFormula.size step 2) {
        val operand = toDouble(trimFormula[i + 1])
        val operator = Operator.of(trimFormula[i])
        answer = operator.calculate(answer, operand)
    }
    return answer
}
