package domain

import constant.StringConstant
import enums.ErrorCode
import enums.Operator

class CalculationDto(
    val numbers: List<Int> = mutableListOf(),
    val operators: List<String> = mutableListOf()
) {
    companion object {

        fun from(expression: String?): CalculationDto {
            require(!expression.isNullOrBlank()) { ErrorCode.ERROR_EXPRESSION_NOT_NULL_OR_BLANK.code + ": 입력값은 null 이거나 공백 문자일 수 없습니다." }

            val split = expression.split(StringConstant.BLANK)
            //연산자 목록에 포함된 값이면 true, 아니면 false
            val separate = split.groupBy {
                Operator.getOperators().contains(it)
            }

            val operators = separate[true] ?: mutableListOf()
            val numbers = separate[false] ?: mutableListOf()

            return of(numbers = numbers, operators = operators)
        }

        fun of(numbers: List<String>, operators: List<String>): CalculationDto {

            val convertedNumbers = numbers.map {
                val origin = it
                it.toIntOrNull() ?: throw java.lang.IllegalArgumentException(ErrorCode.ERROR_NOT_ALLOWED_SYMBOL.code + ": 잘못된 수식 \'${origin}\'이 포함되어 있습니다.")
            }

            return CalculationDto(convertedNumbers, operators)
        }
    }
}