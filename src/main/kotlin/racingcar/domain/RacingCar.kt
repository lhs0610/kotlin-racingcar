package racingcar.domain

import racingcar.constant.Message
import racingcar.strategy.RaceStrategy

class RacingCar(
    val racerName: String,
    private var position: RacingCarPosition
) {

    init {
        require(racerName.length <=5 ) { Message.INVALID_INPUT_VALUE_CANNOT_HIGHER_THEN_FIVE.message }
    }

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
