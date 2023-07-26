package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCar

class RacingCarTest : ExpectSpec({

    context("RacingCar test") {
        expect("construct test") {
            val racingCar = RacingCar.of("Jinni", 0)

            racingCar.getDistance() shouldBe 0
            racingCar.getRacerName() shouldBe "Jinni"
        }

        expect("construct test - name length error") {
            shouldThrow<IllegalArgumentException> {
                RacingCar.of("JinniJinni", 0)
            }
        }

        expect("move test") {
            val racingCar = RacingCar.of("Jinni", 0)
            racingCar.attemptMove { true }

            racingCar.getDistance() shouldBe 1
        }
    }
})
