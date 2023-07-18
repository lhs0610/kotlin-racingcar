package racingcar.domain

@JvmInline
value class RacingCarPosition(val distance: Int) {

    operator fun plus(value: Int): RacingCarPosition {
        return RacingCarPosition(distance + value)
    }
}