package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCar
import racingcar.domain.RacingCarPosition

class RacingCarTest : ExpectSpec({

    context("RacingCar test") {
        expect("construct test") {
            val racingCar = RacingCar("Jinni", RacingCarPosition(0))

            racingCar.getDistance() shouldBe 0
            racingCar.racerName shouldBe "Jinni"
        }

        expect("construct test - name length error") {
            shouldThrow<IllegalArgumentException> {
                RacingCar("JinniJinni", RacingCarPosition(0))
            }
        }

        expect("move test") {
            val racingCar = RacingCar("car", RacingCarPosition(0))
            racingCar.attemptMove { true }

            racingCar.getDistance() shouldBe 1
        }
    }
})
