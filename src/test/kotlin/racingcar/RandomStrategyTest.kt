package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeInRange
import racingcar.strategy.RandomStrategy

class RandomStrategyTest : BehaviorSpec({

    Given("test range") {
        val testRange = (1..5)
        When("RandomStrategy의 allowMove 메서드 반환값을 정수형으로 바꿔 합산했을 때") {
            val result = testRange.reduce { result, _ ->
                result + if (RandomStrategy.allowMove()) {
                    1
                } else {
                    0
                }
            }
            Then("총 합은 test range안에 들어야 한다") {
                result shouldBeInRange testRange
            }
        }
    }
})
