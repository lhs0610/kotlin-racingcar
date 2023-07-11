package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RacingCarTest : BehaviorSpec({
    Given("1칸씩 이동하는 자동차를 제공한다.") {
        val racingCar = RacingCar { 1 }
        When("자동차가 움직일 때") {
            racingCar.move()
            Then("정책대로 1칸 움직인다.") {
                racingCar.movedDistance shouldBe 1
            }
        }
    }
})