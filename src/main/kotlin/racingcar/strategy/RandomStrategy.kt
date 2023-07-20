package racingcar.strategy

object RandomStrategy: RaceStrategy {

    private const val MIN_RANDOM_VALUE = 0
    private const val MAX_RANDOM_VALUE = 9

    private const val MOVE_STANDARD = 4

    override fun allowMove(): Boolean {
        val randInt = (MIN_RANDOM_VALUE..MAX_RANDOM_VALUE).random()
        return randInt >= MOVE_STANDARD
    }
}