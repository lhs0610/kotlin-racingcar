package racingcar.domain

import racingcar.component.RacingCarFactory
import racingcar.constant.ErrorMessage
import racingcar.dto.StepHistoryDto
import racingcar.strategy.RaceStrategy

class RacingCarContainer(
    racingCarQuantity: Int,
    position: RacingCarPosition
) {
    private val racingCars: List<RacingCar>

    init {
        require(racingCarQuantity > 0) { ErrorMessage.INVALID_RACINGCAR_QUANITY.message }
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