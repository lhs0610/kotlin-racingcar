package domain.racingcar

import domain.racingcar.factory.RacingCarFactory
import domain.racingcar.constant.ErrorMessage
import domain.racingcar.dto.StepHistoryDto
import domain.racingcar.strategy.RaceStrategy

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