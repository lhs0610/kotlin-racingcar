package racingcar.controller

import racingcar.config.Configuration
import racingcar.model.RaceSetting
import racingcar.service.RacingGameService
import racingcar.strategy.RandomStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

object RacingGameController {
    fun startRacingGame(config: Configuration) {
        val inputView = InputView(config.getResolvers(), config.getValidators())
        val userInput = inputView.getUserInput()
        val result = RacingGameService.startRacingGame(
            raceSetting = RaceSetting.from(userInput),
            raceStrategy = RandomStrategy
        )
        ResultView.printRacingGameResult(result)
    }
}
