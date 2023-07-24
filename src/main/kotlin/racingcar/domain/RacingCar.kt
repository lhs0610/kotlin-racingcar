package racingcar.domain

import racingcar.model.RacerName
import racingcar.strategy.RaceStrategy

class RacingCar private constructor(
    private val racerName: RacerName,
    private var distance: RacingCarDistance
) {
    fun getDistance(): Int {
        return distance.distance
    }

    fun getRacerName(): String {
        return racerName.racerName
    }

    fun attemptMove(raceStrategy: RaceStrategy) {
        if (raceStrategy.allowMove()) {
            move()
        }
    }

    private fun move() {
        distance += MOVE_OFFSET
    }

    companion object {
        private const val MOVE_OFFSET = 1

        fun of(racerName: String, distance: Int): RacingCar {
            return RacingCar(RacerName(racerName), RacingCarDistance(distance))
        }
    }
}
