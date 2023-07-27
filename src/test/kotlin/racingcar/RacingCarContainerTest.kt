package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCarContainer
import racingcar.model.RacingCarSetting

class RacingCarContainerTest : BehaviorSpec({

    Given("List<RacingCarSetting>") {
        val initPosition = 5
        val settings = listOf(
            RacingCarSetting("JN1", initPosition),
            RacingCarSetting("JN2", initPosition),
            RacingCarSetting("JN3", initPosition)
        )
        When("주어진 설정으로 초기화된 RacingCarContainer의 stepProgress 메서드를 호출하면(무조건 이동 정책 사용)") {
            val racingCarContainer = RacingCarContainer.from(settings)
            val stepHistory = racingCarContainer.stepProgress { true }
            Then("반환된 StepHistory의 레이서 이름이 각각 일치해야 하고, 전부 표기된 거리가 1증가해 있어야 한다.") {
                stepHistory shouldHaveSize settings.size
                stepHistory.zip(settings).forAll {
                    it.first.racerName shouldBe it.second.racerName
                    it.first.distance shouldBe initPosition + 1
                }
            }
        }
    }
})
