package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCarContainer
import racingcar.model.RacingCarSetting

class RacingCarContainerTest : ExpectSpec({

    context("RacingCarContainer test") {
        expect("step progress test") {

            val settings = listOf(
                RacingCarSetting("JN1", 0),
                RacingCarSetting("JN2", 0),
                RacingCarSetting("JN3", 0)
            )

            val racingCarContainer = RacingCarContainer.from(settings)
            val stepHistory = racingCarContainer.stepProgress { true }

            stepHistory shouldHaveSize settings.size
            stepHistory.zip(settings).forAll {
                it.first.racerName shouldBe it.second.racerName
                it.first.distance shouldBe 1
            }
        }
    }
})
