package racingcar.controller

import racingcar.service.GameService
import racingcar.strategy.RandomStrategy
import racingcar.view.InputView
import racingcar.view.ResultView
import java.util.Random

object GameController {

    fun startRacingGame() {
        val userInput = InputView.getUserInput()
        val result = GameService.startRacingGame(userInput.racingcarQuantity, userInput.totalStep, RandomStrategy)
        ResultView.printRacingGameResult(result)
    }
}