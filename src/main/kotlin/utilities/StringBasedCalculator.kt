package utilities

import enums.ErrorCode
import enums.Operator

object StringBasedCalculator {

    private const val FIRST_OPERAND_INDEX = 0;
    private const val OPERATOR_OFFSET = 1;

    fun calculate(delimiter: String, expression: String?): Int {

        require(!Operator.getMapping().containsKey(delimiter)) { "${ErrorCode.ERROR_CANNOT_USE_OPERATOR_AS_DELIMITER.code}: \'${delimiter}\'는 구분자로 사용할 수 없습니다." }
        require(!expression.isNullOrBlank()) { "${ErrorCode.ERROR_EXPRESSION_NOT_NULL_OR_BLANK.code}: 입력값은 null 이거나 공백 문자일 수 없습니다." }

        val split = expression.split(delimiter);
        require(split.sizeIsOdd()) { "${ErrorCode.ERROR_OPERATOR_OPERAND_COUNT_NOT_MATCH.code}: 입력된 연산자와 피연산자의 수가 잘못되었습니다. 합은 홀수여야 합니다. 입력값:\'${expression}\'" }

        var result = convertStringToIntCheckNumeric(split[FIRST_OPERAND_INDEX]);

        for (index in OPERATOR_OFFSET until split.size step 2) {
            val operator = getExistOperator(split[index])
            val operand = convertStringToIntCheckNumeric(split[index + OPERATOR_OFFSET])

            result = Operator.calculate(operator, result, operand)
        }

        return result
    }
    
    private fun getExistOperator(operator: String): String {
        require(Operator.getMapping().containsKey(operator)) { "${ErrorCode.ERROR_NOT_ALLOWED_SYMBOL.code}: 잘못된 수식 \'${operator}\'이 포함되어 있습니다." }
        return operator;
    }

    private fun convertStringToIntCheckNumeric(origin: String): Int {
        return origin.toIntOrNull() ?: throw java.lang.IllegalArgumentException("${ErrorCode.ERROR_IS_NOT_NUMERIC.code}: \'${origin}\'은 숫자가 아닙니다.")
    }
}

fun List<String>.sizeIsOdd(): Boolean {
    return this.size % 2 == 1
}