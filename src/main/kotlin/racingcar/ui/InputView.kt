package racingcar.ui

fun inputRacingCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(${NAME_DELIMITER})를 기준으로 구분).")

    val input: String = readlnOrNull()
        ?: throw IllegalArgumentException("자동차 이름을 입력해주세요.")

    return input.split(NAME_DELIMITER)
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

const val NAME_DELIMITER = ","
