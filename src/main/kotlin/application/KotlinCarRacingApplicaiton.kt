package application

import domain.racingcar.RacingCarContainer
import domain.racingcar.component.Race
import domain.racingcar.strategy.RandomStrategy
import views.InputView
import views.ResultView

fun main() {

    val racingcarQuantity = InputView.inputRacingCarQuantity()
    val totalStep = InputView.inputTotalStep()

    val race = Race(racingcarQuantity = racingcarQuantity, totalStep = totalStep, RandomStrategy)
    val raceHistory = race.start()

    ResultView.printRaceHistory(raceHistory)
}