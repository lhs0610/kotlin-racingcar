package racingcar.domain

import racingcar.contants.ErrorType

class RacingCars(
    carNames: List<String>,
    movePolicy: MovePolicy
) {
    private val _racingCars: List<RacingCar>

    init {
        require(carNames.isNotEmpty()) {
            ErrorType.INVALID_CAR_NUMBER.message
        }

        _racingCars = carNames.map {
            name -> RacingCar(name, movePolicy)
        }
    }

    fun step() {
        _racingCars.forEach { it.move() }
    }

    val cars: List<RacingCar>
        get() = ArrayList(_racingCars)
}
