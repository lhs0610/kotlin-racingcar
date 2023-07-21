package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import racingcar.component.RacingCarFactory
import racingcar.domain.RacingCar
import racingcar.domain.RacingCarPosition
import racingcar.model.RacingCarSetting

class RacingCarFactoryTest : ExpectSpec({

    context("RacingCarFactory test") {
        expect("generate racingcar list test") {

            val settings = listOf(
                RacingCarSetting("JN1", 0),
                RacingCarSetting("JN2", 0),
                RacingCarSetting("JN3", 0)
            )
            val generated = RacingCarFactory.generateRacingCars(settings)

            generated shouldHaveSize settings.size
            generated.zip(settings).forAll {
                it.first.racerName shouldBe it.second.racerName
                it.first.getDistance() shouldBe it.second.initPosition
            }
        }
    }
})
