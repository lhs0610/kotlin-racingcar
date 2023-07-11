package stringcalculator.domain.expression

import stringcalculator.domain.SplitPolicy

class SpaceSplitPolicy : SplitPolicy {
    override fun split(expression: String): List<String> = expression.split(DELIMITER)

    companion object {
        private const val DELIMITER = " "
    }
}