package stringcalculator.domain

class ExpressionExtractor(
    val operandExtractor: OperandExtractor,
    val operatorExtractor: OperatorExtractor
) {
    fun extract(splits: List<String>): Expression {
        val operands = operandExtractor.extract(splits)
        val operators = operatorExtractor.extract(splits)

        return Expression(operands = ArrayDeque(operands), operators = ArrayDeque(operators))
    }
}