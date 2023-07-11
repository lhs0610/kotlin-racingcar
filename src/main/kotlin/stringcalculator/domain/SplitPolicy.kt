package stringcalculator.domain

interface SplitPolicy {
    fun split(expression: String): List<String>
}