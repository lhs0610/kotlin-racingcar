package racingcar.domain

import racingcar.contants.ErrorType
import java.util.concurrent.atomic.AtomicInteger

@JvmInline
value class RacingCarDistance(
    private val _distance: AtomicInteger = AtomicInteger(0)
) {
    init {
        require(_distance.get() >= 0) {
            ErrorType.INVALID_MOVED_DISTANCE.message
        }
    }

    val distance: Int
        get() = _distance.get()

    fun increase(moveDistance: Int) {
        _distance.addAndGet(moveDistance)
    }
}
