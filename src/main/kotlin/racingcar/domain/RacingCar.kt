package racingcar.domain

import racingcar.strategy.RaceStrategy

class RacingCar(
    private var position: RacingCarPosition
) {

    fun getDistance():Int {
        return position.distance
    }

    fun attemptMove(raceStrategy: RaceStrategy) {
        if (!raceStrategy.allowMove()) {
            return
        }
        move()
    }

    private fun move() {
        position += 1
    }
}