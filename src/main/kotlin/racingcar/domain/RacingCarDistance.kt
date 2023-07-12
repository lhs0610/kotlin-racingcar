package racingcar.domain

import racingcar.contants.ErrorType
import java.util.concurrent.atomic.AtomicInteger

@JvmInline
value class RacingCarDistance(
    private val distanceValue: AtomicInteger = AtomicInteger(0)
) {
    val distance: Int
        get() = distanceValue.get()

    init {
        require(distanceValue.get() >= 0) {
            ErrorType.INVALID_MOVED_DISTANCE.message
        }
    }

    fun increase(moveDistance: Int) {
        distanceValue.addAndGet(moveDistance)
    }
}
