package domain

class RacingCar() {
    private val _position = RacingCarPosition()

    val position: Int
        get() = _position.position

    fun attemptMove(distance: Int) {
        val randomInt = (0..10).random()
        if (randomInt < 4) {
            return
        }

        move(distance)
    }

    fun move(distance: Int) {
        _position.move(distance)
    }
}