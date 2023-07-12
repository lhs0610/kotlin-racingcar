package racingcar.domain

class RacingCar(
    private val movePolicy: MovePolicy
) {
    private val racingCarDistance: RacingCarDistance = RacingCarDistance()

    fun move() {
        val moved = movePolicy.move()
        racingCarDistance.increase(moved)
    }

    val movedDistance: Int
        get() = racingCarDistance.distance
}