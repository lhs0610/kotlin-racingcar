package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.model.EntryInput
import racingcar.model.RaceSetting
import racingcar.model.RacingCarSetting
import racingcar.model.TotalStepInput
import racingcar.model.UserInput

class RaceSettingTest : ExpectSpec({
    context("RaceSetting test") {
        expect("factory method test") {
            val input = UserInput(EntryInput(listOf("rc1", "rc2")), TotalStepInput(5))
            val setting = RaceSetting.from(input)

            setting.totalStep shouldBe 5
            setting.racingCarSettings shouldBe listOf(RacingCarSetting("rc1"), RacingCarSetting("rc2"))
        }
    }
})
