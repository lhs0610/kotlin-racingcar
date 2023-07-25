package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.model.RaceHistory
import racingcar.model.StepHistory
import racingcar.model.StepRacingCarInfo

class RaceHistoryTest : ExpectSpec({
    context("RaceHistory test") {
        expect("get winner group test") {

            val step1 = StepHistory(
                listOf(
                    StepRacingCarInfo("rc1", 1),
                    StepRacingCarInfo("rc2", 1)
                )
            )

            val step2 = StepHistory(
                listOf(
                    StepRacingCarInfo("rc1", 2),
                    StepRacingCarInfo("rc2", 1)
                )
            )

            val history = RaceHistory(listOf(step1, step2))
            val winnerGroupEntry = history.getWinnerGroupEntry()

            winnerGroupEntry.key shouldBe 2
            winnerGroupEntry.value shouldBe listOf("rc1")
        }
    }
})
