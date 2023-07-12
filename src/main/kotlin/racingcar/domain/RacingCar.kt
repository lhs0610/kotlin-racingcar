package racingcar.domain

class RacingCar(
    name: String,
    private val movePolicy: MovePolicy,
) {
    private val _distance: RacingCarDistance = RacingCarDistance()
    private val _name: RacingCarName

    init {
        this._name = RacingCarName(name)
    }

    val name: String
        get() = _name.name

    val movedDistance: Int
        get() = _distance.distance


    fun move() {
        val moved = movePolicy.move()
        _distance.increase(moved)
    }
}
