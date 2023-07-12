package racingcar.domain

class RacingCar(
    name: String,
    private val movePolicy: MovePolicy,
) {
    private val racingCarDistance: RacingCarDistance = RacingCarDistance()
    private val _name: RacingCarName

    init {
        this._name = RacingCarName(name)
    }

    val movedDistance: Int
        get() = racingCarDistance.distance

    val name: String
        get() = _name.name

    fun move() {
        val moved = movePolicy.move()
        racingCarDistance.increase(moved)
    }
}
