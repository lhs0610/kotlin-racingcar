package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.model.EntryInput
import racingcar.model.RaceSetting
import racingcar.model.RacingCarSetting
import racingcar.model.TotalStepInput
import racingcar.model.UserInput

class RaceSettingTest : BehaviorSpec({

    Given("UserInput") {
        val firstRacerName = "rc1"
        val secondRacerName = "rc2"
        val entries = listOf(firstRacerName, secondRacerName)
        val totalStep = 5
        val input = UserInput(EntryInput(entries), TotalStepInput(totalStep))
        When("UserInput으로 RaceSetting을 생성하면") {
            val setting = RaceSetting.from(input)
            Then("반환된 RacingCarSetting의 설정값과 입력한 참가자 정보, 총 스텝이 일치해야 한다") {
                setting.totalStep shouldBe totalStep
                setting.racingCarSettings shouldBe listOf(RacingCarSetting(firstRacerName), RacingCarSetting(secondRacerName))
            }
        }
    }
})
