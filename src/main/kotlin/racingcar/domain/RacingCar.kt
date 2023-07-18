package racingcar.domain

import racingcar.strategy.RaceStrategy

class RacingCar(
    private val raceStrategy: RaceStrategy,
    private var position: RacingCarPosition
) {

    fun getDistance():Int {
        return position.distance
    }

    fun attemptMove() {
        if (!raceStrategy.allowMove()) {
            return
        }
        move()
    }

    private fun move() {
        position += 1
    }
}