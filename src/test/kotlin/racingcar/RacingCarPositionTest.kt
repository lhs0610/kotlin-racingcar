package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCarDistance

class RacingCarPositionTest : ExpectSpec({

    context("RacingCarPosition test") {
        expect("construct test") {
            val position = RacingCarDistance(0)

            position.distance shouldBe 0
        }

        expect("plus test") {
            val position = RacingCarDistance(0)
            val moved = position + 3

            moved.distance shouldBe 3
        }

        expect("minus test") {
            val position = RacingCarDistance(5)
            val moved = position - 7

            moved.distance shouldBe 0
        }
    }
})
