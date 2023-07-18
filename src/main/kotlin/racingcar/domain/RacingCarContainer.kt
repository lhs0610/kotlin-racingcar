package racingcar.domain

import racingcar.component.RacingCarFactory
import racingcar.constant.ErrorMessage
import racingcar.dto.StepHistoryDto
import racingcar.strategy.RaceStrategy

class RacingCarContainer(
    racingCarQuantity: Int,
    raceStrategy: RaceStrategy
) {
    private val racingCars: List<RacingCar>

    init {
        require(racingCarQuantity > 0) { ErrorMessage.INVALID_RACINGCAR_QUANITY.message }
        racingCars = RacingCarFactory.generateRacingCars(racingCarQuantity, raceStrategy)
    }

    fun stepProgress(): StepHistoryDto {
        racingCars.forEach { it.attemptMove() }
        val positions = racingCars.map { it.position }.toList()

        return StepHistoryDto(positions)
    }
}