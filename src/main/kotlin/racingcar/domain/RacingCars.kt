package racingcar.domain

import racingcar.contants.ErrorType

class RacingCars(
    carNames: List<String>,
    movePolicy: MovePolicy
) {
    private val _cars: List<RacingCar>

    init {
        require(carNames.isNotEmpty()) {
            ErrorType.INVALID_CAR_NUMBER.message
        }

        _cars = carNames.map {
            name -> RacingCar(name, movePolicy)
        }
    }

    fun step() {
        _cars.forEach { it.move() }
    }

    val cars: List<RacingCar>
        get() = ArrayList(_cars)

    val winners: List<RacingCar>
        get() {
            val max = _cars.max()
            return cars.filter { car -> car.compareTo(max) == 0 }
        }
}
