package racingcar.domain

import racingcar.contants.ErrorType

class RacingCarDistance(
    private var distanceValue: Int = 0
) {
    val distance: Int
        get() = distanceValue

    init {
        require(distanceValue >= 0) {
            ErrorType.INVALID_MOVED_DISTANCE.message
        }
    }

    fun increase(moveDistance: Int = 0) {
        distanceValue += moveDistance
    }
}
