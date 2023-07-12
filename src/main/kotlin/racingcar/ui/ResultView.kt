package racingcar.ui

import racingcar.model.RaceResultDto

fun printRaceResult(raceResult: RaceResultDto) {
    println("실행 결과")

    val result = raceResult.stepResults.joinToString(separator = STEP_SEPARATOR) {
        stepResult ->
        stepResult.movedDistanceList
            .joinToString(separator = RACING_CAR_SEPARATOR) { movedDistance -> MOVED_DISTANCE.repeat(movedDistance) }
    }

    println(result)
}

private const val MOVED_DISTANCE = "-"
private const val RACING_CAR_SEPARATOR = "\n"
private const val STEP_SEPARATOR = "\n\n"
