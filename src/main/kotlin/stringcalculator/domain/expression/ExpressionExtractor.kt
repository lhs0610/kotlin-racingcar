package stringcalculator.domain.expression

import stringcalculator.domain.operand.OperandExtractPolicy
import stringcalculator.domain.operator.OperatorExtractPolicy

class ExpressionExtractor(
    private val operandExtractPolicy: OperandExtractPolicy = OperandExtractPolicy(),
    private val operatorExtractPolicy: OperatorExtractPolicy = OperatorExtractPolicy()
) {
    fun extract(splits: List<String>): Expression {
        val operands = operandExtractPolicy.extract(splits)
        val operators = operatorExtractPolicy.extract(splits)

        return Expression(operands = ArrayDeque(operands), operators = ArrayDeque(operators))
    }
}