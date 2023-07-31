package racingcar.application

import racingcar.config.Configuration
import racingcar.controller.RacingGameController

fun main() {
    val controller = RacingGameController(Configuration.getRacingGameConfig())
    controller.startRacingGame()
}
