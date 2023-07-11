package stringcalculator.domain

import stringcalculator.enums.Operator

class OperatorExtractor {
    fun extract(expString: List<String>): List<Operator> =
        expString.filterIndexed { index, _ -> index % 2 == 1 }
            .map { Operator.of(it) }
            .toList()
}