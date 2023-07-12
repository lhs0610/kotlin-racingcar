package racingcar.domain

import kotlin.random.Random

object RandomMovePolicy : MovePolicy {

    override fun move(): Int {
        val random = Random.nextInt(RANDOM_MAX + 1)
        return if (random >= STEP_THRESHOLD) ONE_STEP else NO_STEP
    }

    private const val STEP_THRESHOLD = 4

    private const val ONE_STEP = 1
    private const val NO_STEP = 0

    private const val RANDOM_MAX = 9
}
