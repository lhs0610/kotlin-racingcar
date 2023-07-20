package racingcar.controller

import racingcar.service.RacingGameService
import racingcar.strategy.RandomStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

object RacingGameController {

    fun startRacingGame() {
        val userInput = InputView.getUserInput()
        val result = RacingGameService.startRacingGame(
            racingcarQuantity = userInput.racingcarQuantity,
            totalStep = userInput.totalStep,
            raceStrategy = RandomStrategy
        )
        ResultView.printRacingGameResult(result)
    }
}
