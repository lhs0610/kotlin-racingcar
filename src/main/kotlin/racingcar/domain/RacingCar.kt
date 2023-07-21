package racingcar.domain

import racingcar.strategy.RaceStrategy

class RacingCar(
    private var position: RacingCarPosition,
) {

    fun getDistance(): Int {
        return position.distance
    }

    fun attemptMove(raceStrategy: RaceStrategy) {
        if (raceStrategy.allowMove()) {
            move()
        }
    }

    private fun move() {
        position += MOVE_OFFSET
    }

    companion object {
        private const val MOVE_OFFSET = 1
    }
}
