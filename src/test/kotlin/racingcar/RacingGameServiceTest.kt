package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import racingcar.service.RacingGameService

class RacingGameServiceTest : ExpectSpec({

    context("RacingGameService test") {
        expect("start game test") {
            val raceHistory = RacingGameService.startRacingGame(
                racingcarQuantity = 4,
                totalStep = 5
            ) { true }

            val lastStepHistory = raceHistory.stepHistories.last()
            lastStepHistory.positions.forAll { it.shouldBe(5) }
        }
    }
})
