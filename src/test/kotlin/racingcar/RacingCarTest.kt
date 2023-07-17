package racingcar

import domain.RacingCar
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import utilities.NumberUtil

class RacingCarTest: ExpectSpec({

    context("기능 테스트") {

        expect("레이싱카 객체를 생성해 5만큼 이동") {
            val racingCar = RacingCar()
            racingCar.position shouldBe 0

            racingCar.move(5)
            racingCar.position shouldBe 5
        }
    }
})