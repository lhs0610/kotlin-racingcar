package stringcalculator.domain.expression

import stringcalculator.domain.ExtractPolicy
import stringcalculator.domain.operand.Operand
import stringcalculator.domain.operator.Operator

class ExpressionExtractor(
    private val operandExtractPolicy: ExtractPolicy<List<Operand>>,
    private val operatorExtractPolicy: ExtractPolicy<List<Operator>>
) {
    fun extract(splits: List<String>): Expression {
        val operands = operandExtractPolicy.extract(splits)
        val operators = operatorExtractPolicy.extract(splits)

        return Expression(operands = ArrayDeque(operands), operators = ArrayDeque(operators))
    }
}
