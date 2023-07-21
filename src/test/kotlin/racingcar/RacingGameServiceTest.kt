package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldHave
import racingcar.model.RaceSetting
import racingcar.model.RacingCarSetting
import racingcar.service.RacingGameService

class RacingGameServiceTest : ExpectSpec({

    context("RacingGameService test") {
        expect("start game test") {

            val totalStep = 5
            val carSettings = listOf(
                RacingCarSetting("JN1", 0),
                RacingCarSetting("JN2", 0),
                RacingCarSetting("JN3", 0)
            )

            val raceSetting = RaceSetting(carSettings, totalStep)
            val raceHistory = RacingGameService.startRacingGame(raceSetting) { true }

            val lastCarInfos = raceHistory.stepHistories.last().stepRacingCarInfos

            lastCarInfos shouldHaveSize carSettings.size
            lastCarInfos.zip(carSettings).forAll {
                it.first.racerName shouldBe it.second.racerName
                it.first.distance shouldBe totalStep
            }
        }
    }
})
