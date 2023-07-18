package racingcar.application

import racingcar.component.Race
import racingcar.strategy.RandomStrategy
import racingcar.views.InputView
import racingcar.views.ResultView

fun main() {

    val racingcarQuantity = InputView.inputRacingCarQuantity()
    val totalStep = InputView.inputTotalStep()

    val race = Race(racingcarQuantity = racingcarQuantity, totalStep = totalStep, RandomStrategy)
    val raceHistory = race.start()

    ResultView.printRaceHistory(raceHistory)
}