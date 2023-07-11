package racingcar.domain

class RacingCars(
    racingCarNum: Int,
    movePolicy: MovePolicy
) {
    private val racingCars = mutableListOf<RacingCar>()

    init {
        for (i in 0 until racingCarNum)
            racingCars.add(RacingCar(movePolicy))
    }

    fun step() {
        racingCars.forEach { it.move() }
    }

    val movedDistanceList: List<Int>
        get() = racingCars.map { it.movedDistance }
            .toList()
}