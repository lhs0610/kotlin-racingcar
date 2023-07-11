package utilities

import domain.CalculationDto
import enums.ErrorCode
import enums.Operator

class StringBasedCalculatorV2 {

    companion object {

        fun calculate(expression: String?): Int {
            return calculate(CalculationDto.from(expression))
        }

        private fun calculate(calculationDto: CalculationDto): Int {
            val numbersIterator = calculationDto.numbers.iterator()
            val operatorsIterator = calculationDto.operators.iterator()

            var result = numbersIterator.next()

            while(numbersIterator.hasNext() && operatorsIterator.hasNext()) {
                val number = numbersIterator.next()
                val operator = operatorsIterator.next()
                result = solveExpression(result, number, operator)
            }

            return result
        }

        private fun solveExpression(prefix: Int, postfix: Int, operator: String): Int {
            return when(operator) {
                Operator.PLUS.operator -> prefix + postfix
                Operator.MINUS.operator -> prefix - postfix
                Operator.MULTIPLY.operator -> prefix * postfix
                Operator.DIVIDE.operator -> {
                    if (postfix == 0) {
                        throw IllegalArgumentException(ErrorCode.ERROR_DIVIDER_CANNOT_ZERO.code + ": 나누는 수는 0이 될 수 없습니다.")
                    }
                    prefix / postfix
                }
                else -> throw IllegalArgumentException(ErrorCode.ERROR_NOT_ALLOWED_SYMBOL.code + ": 허용되지 않은 사칙연산 기호 \'${operator}\'가 포함되어 있습니다.")
            }
        }
    }
}