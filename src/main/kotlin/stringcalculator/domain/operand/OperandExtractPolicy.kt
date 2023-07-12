package stringcalculator.domain.operand

import stringcalculator.domain.ExtractPolicy

class OperandExtractPolicy : ExtractPolicy<List<Operand>> {
    override fun extract(expString: List<String>): List<Operand> =
        expString.filterIndexed { index, _ -> index % 2 == 0 }
            .map { Operand(it.toDouble()) }
            .toList()
}
