package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCarContainer
import racingcar.model.vo.RacingCarSettingVO

class RacingCarContainerTest : ExpectSpec({

    context("RacingCarContainer test") {
        expect("step progress test") {

            val quantity = 3
            val settings = List(quantity) { RacingCarSettingVO(0) }

            val racingCarContainer = RacingCarContainer.from(settings)
            val stepHistory = racingCarContainer.stepProgress { true }

            stepHistory shouldHaveSize quantity
            stepHistory.forAll { it.shouldBe(1) }
        }
    }
})
