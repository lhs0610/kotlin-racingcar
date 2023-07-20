package racingcar

import racingcar.view.InputView

fun main() {

    val input = InputView()
    input.carInfo()

    val race = Race()
    race.ready(input.getCarCount())
    race.start(input.getTryCount())

    race.end()
}
