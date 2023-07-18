package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.component.RacingCarFactory
import racingcar.domain.RacingCar
import racingcar.domain.RacingCarPosition

class RacingCarTest: ExpectSpec({

    context("RacingCarPosition test") {
        expect("construct test") {
            val position = RacingCarPosition(0)

            position.distance shouldBe 0
        }

        expect("plus test") {
            val position = RacingCarPosition(0)
            val moved = position + 3

            moved.distance shouldBe 3
        }

        expect("minus test") {
            val position = RacingCarPosition(5)
            val moved = position - 7

            moved.distance shouldBe 0
        }
    }

    context("RacingCar test") {
        expect("construct test") {
            val racingCar = RacingCar(RacingCarPosition(0))

            racingCar.getDistance() shouldBe 0
        }

        expect("move test") {
            val racingCar = RacingCar(RacingCarPosition(0))
            racingCar.attemptMove { true }

            racingCar.getDistance() shouldBe 1
        }
    }

    context("RacingCarFactory test") {
        expect("generate racingcar list test") {
            val racingCars = RacingCarFactory.generateRacingCars(3, RacingCarPosition(0))
            for (racingCar in racingCars) {
                racingCar.getDistance() shouldBe 0
            }
        }
    }

})