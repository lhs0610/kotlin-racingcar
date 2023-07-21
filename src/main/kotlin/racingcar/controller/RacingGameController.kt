package racingcar.controller

import racingcar.model.RaceSetting
import racingcar.service.RacingGameService
import racingcar.strategy.RandomStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

object RacingGameController {

    fun startRacingGame() {
        val userInput = InputView.getUserInput()
        val result = RacingGameService.startRacingGame(
            raceSetting = RaceSetting.from(userInput),
            raceStrategy = RandomStrategy
        )
        ResultView.printRacingGameResult(result)
    }
}
