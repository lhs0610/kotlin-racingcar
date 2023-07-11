package stringcalculator.domain.operator

import stringcalculator.domain.ExtractPolicy

class OperatorExtractPolicy : ExtractPolicy<List<Operator>> {
    override fun extract(expString: List<String>): List<Operator> =
        expString.filterIndexed { index, _ -> index % 2 == 1 }
            .map { Operator.of(it) }
            .toList()
}