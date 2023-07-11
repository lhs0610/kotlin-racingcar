package racingcar.domain

import kotlin.random.Random

class RandomMovePolicy : MovePolicy {

    override fun move(): Int {
        val random = Random.nextInt(RANDOM_MIN, RANDOM_MAX + 1)
        return if (random >= THRESHOLD) ONE_STEP else NO_STEP
    }

    companion object {
        private const val THRESHOLD = 4

        private const val ONE_STEP = 1
        private const val NO_STEP = 0

        private const val RANDOM_MIN = 0
        private const val RANDOM_MAX = 9
    }
}