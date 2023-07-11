package racingcar.ui

import racingcar.model.RaceResultDto

fun printRaceResult(raceResult: RaceResultDto) {
    println("실행 결과")
    raceResult.stepResults.forEach { stepResult ->
        stepResult.movedDistanceList.forEach { movedDistance ->
            (1 .. movedDistance).forEach { _ -> print("-") }
            println()
        }
        println()
    }
}