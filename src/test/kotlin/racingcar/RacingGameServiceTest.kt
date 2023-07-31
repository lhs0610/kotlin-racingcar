package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.model.RaceSetting
import racingcar.model.RacingCarSetting
import racingcar.service.RacingGameService

class RacingGameServiceTest : BehaviorSpec({

    Given("RaceSetting") {
        val totalStep = 5
        val initPosition = 0
        val carSettings = listOf(
            RacingCarSetting("JN1", initPosition),
            RacingCarSetting("JN2", initPosition),
            RacingCarSetting("JN3", initPosition)
        )
        val raceSetting = RaceSetting(carSettings, totalStep)
        When("설정된 RaceSetting을 인자로 RacingGameService의 startRacingGame 메서드를 호출하면(무조건 이동 정책 사용)") {
            val raceHistory = RacingGameService.startRacingGame(raceSetting) { true }
            Then("반환된 RaceHistory의 마지막 StepHistory정보(레이서 이름, 이동 거리)가 설정과 일치해야 한다") {
                val lastStepCarInfos = raceHistory.stepHistories.last().stepRacingCarInfos
                lastStepCarInfos shouldHaveSize carSettings.size
                lastStepCarInfos.zip(carSettings).forAll {
                    it.first.racerName shouldBe it.second.racerName
                    it.first.distance shouldBe totalStep
                }
            }
        }
    }
})
