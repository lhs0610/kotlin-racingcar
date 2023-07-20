package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import racingcar.component.RacingCarFactory
import racingcar.model.vo.RacingCarSettingVO

class RacingCarFactoryTest : ExpectSpec({

    context("RacingCarFactory test") {
        expect("generate racingcar list test") {
            val racingCars = RacingCarFactory.generateRacingCars(List(3) { RacingCarSettingVO() })

            racingCars.map { it.getDistance() }.toList().forAll { it.shouldBe(0) }
        }
    }
})
