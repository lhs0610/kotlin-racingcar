package racingcar

import racingcar.domain.RacingCars
import racingcar.domain.RandomMovePolicy
import racingcar.service.Race
import racingcar.ui.inputRacingCarNames
import racingcar.ui.inputStepNum
import racingcar.ui.printRaceResult

fun main() {
    val racingCarNames = inputRacingCarNames()
    val stepNum = inputStepNum()

    val racingCars = RacingCars(racingCarNames, RandomMovePolicy)
    val race = Race()
    val raceResult = race.start(racingCars, stepNum)

    printRaceResult(raceResult)
}
