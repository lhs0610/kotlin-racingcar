package racingcar.domain

import racingcar.contants.ErrorType

class RacingCars(
    carNames: List<String>,
    movePolicy: MovePolicy
) {
    private val racingCars: List<RacingCar>

    init {
        require(carNames.isNotEmpty()) {
            ErrorType.INVALID_CAR_NUMBER.message
        }

        racingCars = carNames.map {
            name -> RacingCar(name, movePolicy)
        }
    }

    fun step() {
        racingCars.forEach { it.move() }
    }

    val movedDistanceList: List<Int>
        get() = racingCars.map { it.movedDistance }
            .toList()
}
