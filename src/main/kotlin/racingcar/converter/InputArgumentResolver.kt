package racingcar.converter

interface InputArgumentResolver<T> {
    fun validate(input: String): Boolean
    fun resolve(input: String): T
}
