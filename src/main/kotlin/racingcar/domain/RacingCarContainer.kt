package racingcar.domain

import racingcar.component.RacingCarFactory
import racingcar.constant.Message
import racingcar.strategy.RaceStrategy

class RacingCarContainer(
    racingCarQuantity: Int,
    position: RacingCarPosition
) {
    private val racingCars: List<RacingCar>

    init {
        racingCars = RacingCarFactory.generateRacingCars(racingCarQuantity, position)
    }

    fun stepProgress(raceStrategy: RaceStrategy): List<Int> {
        racingCars.forEach() { it.attemptMove(raceStrategy) }
        return racingCars.getAllDistance()
    }
}

fun List<RacingCar>.getAllDistance(): List<Int> {
    return this.map { it.getDistance() }
}