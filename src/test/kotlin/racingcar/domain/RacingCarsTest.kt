package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import racingcar.contants.ErrorType

class RacingCarsTest : BehaviorSpec({
    Given("2칸씩 움직이는 3대의 자동차를 제공한다.") {
        val racingCars = RacingCars(carNames = listOf("A", "B", "C")) { 2 }
        When("5번 시도를 할 때") {
            for (i in 0 until 5)
                racingCars.step()
            Then("모든 자동차가 거리 10만큼 이동해야 한다.") {
                racingCars.movedDistanceList.forEach { it shouldBe 10 }
            }
        }
    }

    Given("빈 자동차 이름 목록을 제공한다.") {
        val carNames = listOf<String>()
        When("RacingCars를 만들 때") {
            Then("예외가 발생한다.") {
                val exception = shouldThrow<IllegalArgumentException> { RacingCars(carNames) { 1 } }
                exception.message should startWith(ErrorType.INVALID_CAR_NUMBER.message)
            }
        }
    }
})
