package domain.racingcar

class RacingCar(
    private val strategy: RaceStrategy = RandomStrategy
) {
    private val _position = RacingCarPosition()

    val position: Int
        get() = _position.position

    fun attemptMove() {
        move(strategy.move())
    }

    fun move(distance: Int) {
        _position.move(distance)
    }
}