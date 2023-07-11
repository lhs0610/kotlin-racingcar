package stringcalculator.domain.calculator

import stringcalculator.constants.ErrorType.INVALID_INPUT_BLANK
import stringcalculator.domain.expression.SpaceSplitPolicy
import stringcalculator.domain.SplitPolicy
import stringcalculator.domain.expression.ExpressionExtractor

class StringCalculator(
    private val splitPolicy: SplitPolicy = SpaceSplitPolicy(),
    private val expExtractor: ExpressionExtractor = ExpressionExtractor()
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