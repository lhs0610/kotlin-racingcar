package racingcar.controller

import racingcar.config.Configuration
import racingcar.model.RaceSetting
import racingcar.service.RacingGameService
import racingcar.strategy.RandomStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGameController(
    private val config: Configuration
) {
    fun startRacingGame() {
        val inputView = InputView(config.resolvers, config.validators)
        val userInput = inputView.getUserInput()
        val result = RacingGameService.startRacingGame(
            raceSetting = RaceSetting.from(userInput),
            raceStrategy = RandomStrategy
        )
        ResultView.printRacingGameResult(result)
    }
}
