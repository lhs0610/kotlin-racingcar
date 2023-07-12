package racingcar.ui

fun inputRacingCarNum(): Int {
    println("자동차 대수는 몇 대인가요?")

    val input: String = readlnOrNull()
        ?: throw IllegalArgumentException("자동차 대수를 입력해주세요.")

    val toIntOrNull = input.toIntOrNull()
    requireNotNull(toIntOrNull) { "자동차 대수는 숫자를 입력해주세요." }
    require(toIntOrNull > 0) { "자동차 대수는 양의 정수를 입력해주세요." }
    return toIntOrNull
}

fun inputStepNum(): Int {
    println("시도할 횟수는 몇 회인가요?")

    val input: String = readlnOrNull()
        ?: throw IllegalArgumentException("시도할 횟수를 입력해주세요.")

    val toIntOrNull = input.toIntOrNull()
    requireNotNull(toIntOrNull) { "시도할 횟수는 숫자를 입력해주세요." }
    require(toIntOrNull > 0) { "시도할 횟수는 양의 정수를 입력해주세요." }

    return toIntOrNull
}
