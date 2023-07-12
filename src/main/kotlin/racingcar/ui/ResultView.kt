package racingcar.ui

import racingcar.model.RaceResultDto

fun printRaceResult(raceResult: RaceResultDto) {
    println("실행 결과")

    val result = raceResult.stepResults.joinToString(separator = STEP_SEPARATOR) {
        stepResult ->
        stepResult.racingCarList
            .joinToString(separator = RACING_CAR_SEPARATOR,) {
                racingCar -> "${racingCar.name} : ${MOVED_DISTANCE.repeat(racingCar.movedDistance)}"
            }
    }

    println(result)
    println()
    println("${raceResult.winners.joinToString(WINNER_SEPARATOR)}가 최종 우승했습니다.")
}

private const val MOVED_DISTANCE = "-"
private const val RACING_CAR_SEPARATOR = "\n"
private const val STEP_SEPARATOR = "\n\n"
private const val WINNER_SEPARATOR = ","
