package utilities

import enums.ErrorCode
import enums.Operator

object StringBasedCalculator {

    private const val FIRST_OPERAND_INDEX = 0
    private const val OPERATOR_OFFSET = 1

    fun calculate(delimiter: String, expression: String?): Int {

        require(!Operator.contains(delimiter)) { "${ErrorCode.ERROR_CANNOT_USE_OPERATOR_AS_DELIMITER.code}: \'${delimiter}\'는 구분자로 사용할 수 없습니다." }
        require(!expression.isNullOrBlank()) { "${ErrorCode.ERROR_EXPRESSION_NOT_NULL_OR_BLANK.code}: 입력값은 null 이거나 공백 문자일 수 없습니다." }

        val split = expression.split(delimiter)
        require(split.sizeIsOdd()) { "${ErrorCode.ERROR_OPERATOR_OPERAND_COUNT_NOT_MATCH.code}: 입력된 연산자와 피연산자의 수가 잘못되었습니다. 합은 홀수여야 합니다. 입력값:\'${expression}\'" }

        val operators = ArrayDeque<String>()
        val operands = ArrayDeque<Int>()

        for ((index, value) in split.withIndex()) {
            if (NumberUtil.isOdd(index)) {
                val operator = getExistOperator(value)
                operators.add(operator)
                continue
            }

            val operand = NumberUtil.convertStringToIntCheckNumeric(value)
            operands.add(operand)
        }

        val firstOperand = operands.removeFirst()
        val zip = operators.zip(operands)

        return zip.fold(firstOperand) { result, pair -> Operator.calculate(pair.first, result, pair.second) }
    }
    
    private fun getExistOperator(operator: String): String {
        require(Operator.contains(operator)) { "${ErrorCode.ERROR_NOT_ALLOWED_SYMBOL.code}: 잘못된 수식 \'${operator}\'이 포함되어 있습니다." }
        return operator
    }
}

fun List<String>.sizeIsOdd(): Boolean {
    return this.size % 2 == 1
}