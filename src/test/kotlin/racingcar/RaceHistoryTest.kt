package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.model.RaceHistory
import racingcar.model.StepHistory
import racingcar.model.StepRacingCarInfo

class RaceHistoryTest : BehaviorSpec({

    Given("RaceHistory") {
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
        When("RaceHistory의 getWinnerGroupEntry메서드를 호출하면") {
            val winnerGroupEntry = history.getWinnerGroupEntry()
            Then("우승자 정보가 반환되어야 한다") {
                winnerGroupEntry.key shouldBe 2
                winnerGroupEntry.value shouldBe listOf("rc1")
            }
        }
    }
})
