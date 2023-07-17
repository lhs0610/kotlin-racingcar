package domain.racingcar

class RacingCarContainer(
    racingCarQuantity: Int,
    raceStrategy: RaceStrategy
) {
    private val racingCars: List<RacingCar>

    init {
        require(racingCarQuantity > 0) { ErrorMessage.INVALID_RACINGCAR_QUANITY.message }
        racingCars = RacingCarFactory.generateRacingCars(racingCarQuantity, raceStrategy)
    }

    fun stepProgress() {
        racingCars.forEach { it.attemptMove() }
    }
}