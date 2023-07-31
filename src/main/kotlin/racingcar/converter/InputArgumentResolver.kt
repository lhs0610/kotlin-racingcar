package racingcar.converter

fun interface InputArgumentResolver<T> {
    fun resolve(input: String): T
}
