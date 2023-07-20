package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.component.RacingCarFactory
import racingcar.model.vo.RacingCarSettingVO

class RacingCarFactoryTest : ExpectSpec({

    context("RacingCarFactory test") {
        expect("generate racingcar list test") {
            val racingCars = RacingCarFactory.generateRacingCars(List(3) { RacingCarSettingVO() })
            for (racingCar in racingCars) {
                racingCar.getDistance() shouldBe 0
            }
        }
    }
})
