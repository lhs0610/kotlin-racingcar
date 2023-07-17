package domain

class RacingCar() {
    private val _position = RacingCarPosition()

    val position: Int
        get() = _position.position

    fun move(distance: Int) {
        _position.move(distance)
    }
}