package stringcalculator.domain

class OperandExtractor {
    fun extract(expString: List<String>): List<Operand> =
        expString.filterIndexed { index, _ -> index % 2 == 0 }
            .map { Operand(it.toDouble()) }
            .toList()
}