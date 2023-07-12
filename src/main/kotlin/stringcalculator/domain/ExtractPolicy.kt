package stringcalculator.domain

interface ExtractPolicy<T> {
    fun extract(expString: List<String>): T
}
