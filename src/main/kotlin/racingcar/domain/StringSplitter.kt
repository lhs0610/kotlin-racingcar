package racingcar.domain

object StringSplitter {

    private const val SYMBOL = ","

    fun split(origin: String): List<String> {
        return origin.split(SYMBOL)
    }
}
