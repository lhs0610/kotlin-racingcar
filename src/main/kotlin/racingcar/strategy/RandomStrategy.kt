package racingcar.strategy

object RandomStrategy: RaceStrategy {

    private const val MIN_RANDOM_VALUE = 0
    private const val MAX_RANDOM_VALUE = 9

    private const val MIN_MOVE = 4
    private const val STAY = 0

    override fun move(): Int {
        val randInt = (MIN_RANDOM_VALUE..MAX_RANDOM_VALUE).random()
        if (randInt < MIN_MOVE) {
            return STAY
        }
        return randInt
    }
}