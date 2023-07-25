package racingcar.converter

interface InputArgumentResolver<T> {
    fun resolve(input: String): T
}
