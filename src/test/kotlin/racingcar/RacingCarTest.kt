package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.component.Race
import racingcar.component.RacingCarFactory
import racingcar.domain.RacingCar
import racingcar.domain.RacingCarContainer
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

    context("RacingCarContainer test") {
        expect("step progress test") {
            val racingCarContainer = RacingCarContainer(5, RacingCarPosition(0))
            val stepHistory = racingCarContainer.stepProgress { true }

            stepHistory.shouldHaveSize(5)
            stepHistory.forAll { it.shouldBe(1) }
        }
    }

    context("Race test") {
        expect("start test") {
            val race = Race(7, 2) { true }
            val raceHistory = race.start()

            raceHistory.stepHistories.shouldHaveSize(2)
            raceHistory.stepHistories.last().positions.forAll { it.shouldBe(2) }
        }
    }

})