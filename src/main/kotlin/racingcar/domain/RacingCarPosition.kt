package racingcar.domain

class RacingCarPosition(
    private var _position: Int = 0
) {
    val position: Int
        get() = _position

    fun move(distance: Int) {
        _position += distance
    }
}