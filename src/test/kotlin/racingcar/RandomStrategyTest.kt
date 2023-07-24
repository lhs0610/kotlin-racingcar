package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.ints.shouldBeInRange
import racingcar.strategy.RandomStrategy

class RandomStrategyTest : ExpectSpec({

    context("RandomStrategy test") {
        expect("repeat test") {
            val testRange = (1..5)
            val result = testRange.reduce { result, _ ->
                result + if (RandomStrategy.allowMove()) {
                    1
                } else {
                    0
                }
            }

            result shouldBeInRange testRange
        }
    }
})
