package racingcar.domain

@JvmInline
value class RacingCarDistance(val value: Int) {

    operator fun plus(value: Int): RacingCarDistance {
        val result = getResultOrZero(this.value + value)
        return RacingCarDistance(result)
    }

    operator fun minus(value: Int): RacingCarDistance {
        val result = getResultOrZero(this.value - value)
        return RacingCarDistance(result)
    }

    private fun getResultOrZero(value: Int): Int {
        return if (value < 0) 0 else value
    }
}
