package stringcalculator.domain.calculator

import stringcalculator.constants.ErrorType.INVALID_INPUT_BLANK
import stringcalculator.domain.SplitPolicy
import stringcalculator.domain.expression.ExpressionExtractor
import stringcalculator.domain.expression.SpaceSplitPolicy
import stringcalculator.domain.operand.OperandExtractPolicy
import stringcalculator.domain.operator.OperatorExtractPolicy

class StringCalculator(
    private val splitPolicy: SplitPolicy = SpaceSplitPolicy(),
    private val expExtractor: ExpressionExtractor = ExpressionExtractor(
        OperandExtractPolicy(),
        OperatorExtractPolicy()
    )
) {
    fun calculate(expString: String?): Double {
        require(!expString.isNullOrBlank()) {
            INVALID_INPUT_BLANK.message
        }

        val splits = splitPolicy.split(expString)
        val expression = expExtractor.extract(splits)
        return expression.calculate()
    }
}