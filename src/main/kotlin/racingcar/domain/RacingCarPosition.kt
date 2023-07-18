package racingcar.domain

@JvmInline
value class RacingCarPosition(val distance: Int) {

    operator fun plus(value: Int): RacingCarPosition {
        val result = getResultOrZero(distance + value)
        return RacingCarPosition(result)
    }

    operator fun minus(value: Int): RacingCarPosition {
        val result = getResultOrZero(distance + value)
        return RacingCarPosition(result)
    }

    private fun getResultOrZero(value: Int): Int {
        return if (value < 0) 0 else value
    }
}