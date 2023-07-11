package racingcar.ui

import racingcar.model.RaceResultDto

fun printRaceResult(raceResult: RaceResultDto) {
    println("실행 결과")
    raceResult.stepResults.forEach { stepResult ->
        stepResult.movedDistanceList.forEach { movedDistance ->
            for(i in 0 until movedDistance)
                print("-")
            println()
        }
        println()
    }
}