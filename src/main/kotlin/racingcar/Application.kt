package racingcar

import racingcar.service.Race
import racingcar.ui.inputRacingCarNum
import racingcar.ui.inputStepNum
import racingcar.ui.printRaceResult

fun main() {
    val racingCarNum = inputRacingCarNum()
    val stepNum = inputStepNum()

    val race = Race(racingCarNum = racingCarNum, stepNum = stepNum)
    val raceResult = race.start()

    printRaceResult(raceResult)
}