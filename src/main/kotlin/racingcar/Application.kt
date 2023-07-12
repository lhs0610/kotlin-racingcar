package racingcar

import racingcar.domain.RacingCars
import racingcar.domain.RandomMovePolicy
import racingcar.service.Race
import racingcar.ui.inputRacingCarNum
import racingcar.ui.inputStepNum
import racingcar.ui.printRaceResult

fun main() {
    val racingCarNum = inputRacingCarNum()
    val stepNum = inputStepNum()

    val racingCars = RacingCars(racingCarNum, RandomMovePolicy)
    val race = Race()
    val raceResult = race.start(racingCars, stepNum)

    printRaceResult(raceResult)
}
