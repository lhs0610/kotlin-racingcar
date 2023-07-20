package racingcar.controller

import racingcar.service.RaceGameService
import racingcar.strategy.RandomStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

object RaceGameController {

    fun startRacingGame() {
        val userInput = InputView.getUserInput()
        val result = RaceGameService.startRacingGame(
            racingcarQuantity = userInput.racingcarQuantity,
            totalStep = userInput.totalStep,
            raceStrategy = RandomStrategy
        )
        ResultView.printRacingGameResult(result)
    }
}
