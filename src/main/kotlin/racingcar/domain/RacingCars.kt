package racingcar.domain

import racingcar.contants.ErrorType

class RacingCars(
    racingCarNum: Int,
    movePolicy: MovePolicy
) {
    private val racingCars: List<RacingCar>

    init {
        require(racingCarNum > 0) {
            ErrorType.INVALID_NUMBER.message
        }

        racingCars = List(racingCarNum) {
            RacingCar(movePolicy)
        }
    }

    fun step() {
        racingCars.forEach { it.move() }
    }

    val movedDistanceList: List<Int>
        get() = racingCars.map { it.movedDistance }
            .toList()
}
