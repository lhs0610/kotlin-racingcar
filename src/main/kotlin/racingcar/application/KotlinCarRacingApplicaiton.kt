package racingcar.application

import racingcar.config.Configuration
import racingcar.controller.RacingGameController

fun main() {
    Configuration.init()
    RacingGameController.startRacingGame()
}
