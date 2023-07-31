package racingcar.application

import racingcar.config.Configuration
import racingcar.config.RacingGameConfiguration
import racingcar.controller.RacingGameController

fun main() {
    RacingGameController.startRacingGame(RacingGameConfiguration)
}
