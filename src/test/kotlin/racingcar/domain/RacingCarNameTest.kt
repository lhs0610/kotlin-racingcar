package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import racingcar.contants.ErrorType

class RacingCarNameTest : BehaviorSpec({
    Given("자동차 이름이 주어진다.") {
        val carName = "이한솔"
        When("RacingCarName 객체를 만들 때") {
            val car = RacingCarName(carName)
            Then("주어진 자동차 이름과 RacingCarName 객체의 이름이 동일하다.") {
                car.name shouldBe carName
            }
        }
    }

    Given("잘못된 자동차 이름이 주어진다.") {
        listOf("", "다섯글자이상").forEach {
            carName ->
            When("RacingCarName 객체를 만들 때") {
                Then("예외가 발생한다.") {
                    val exception = shouldThrow<IllegalArgumentException> { RacingCarName(carName) }
                    exception.message should startWith(ErrorType.INVALID_CAR_NAME.message)
                }
            }
        }
    }
})
