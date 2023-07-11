package racingcar.domain

class RacingCar(
    private val movePolicy: MovePolicy
) {
    var movedDistance: Int = 0
        private set

    fun move() {
        val moved = movePolicy.move()
        movedDistance += moved
    }
}