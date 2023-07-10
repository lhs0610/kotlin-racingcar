package utilities

import constant.StringConstant
import enums.Operators
import enums.Operators.MINUS
import enums.Operators.PLUS

class StringBasedCalculator(
    expression: String?,
    var numbers: List<String> = mutableListOf(),
    var operators: List<String> = mutableListOf()
) {

    init {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("입력값은 null 이거나 공백 문자일 수 없습니다.")
        }

        val split = expression.split(StringConstant.BLANK)
        val separate = split.groupBy {
            Operators.getOperators().contains(it)
        }

        operators = separate[true]!!
        numbers = separate[false]!!
    }

    fun calculate(): Int {

        val convertedNumbers = numbers.map {
            val origin = it
            it.toIntOrNull() ?: throw java.lang.IllegalArgumentException("잘못된 수식 \'${origin}\'이 포함되어 있습니다.")
        }

        val numbersIterator = convertedNumbers.iterator()
        val operatorsIterator = operators.iterator()

        var result = numbersIterator.next();

        while(numbersIterator.hasNext() && operatorsIterator.hasNext()) {
            val number = numbersIterator.next()
            val operator = operatorsIterator.next()
            result = solveExpression(result, number, operator)
        }

        return result
    }

    private fun solveExpression(prefix: Int, postfix: Int, operator: String): Int {
        return when(operator) {
            PLUS.operator -> prefix + postfix
            MINUS.operator -> prefix - postfix
            else -> throw IllegalArgumentException("허용되지 않은 사칙연산 기호 \'${operator}\'가 포함되어 있습니다.")
        }
    }
}