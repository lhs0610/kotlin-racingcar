package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCarDistance

class RacingCarPositionTest : BehaviorSpec({

    Given("초기 위치값") {
        val initDistance = 0
        When("시작 위치를 생성자 인자로 RacingCarPosition을 생성하면") {
            val position = RacingCarDistance(initDistance)
            Then("프로퍼티에 동일한 값이 설정된 RacingCarPosition을 반환한다") {
                position.value shouldBe initDistance
            }
        }
    }

    Given("초기 위치값, 전진 거리") {
        val initDistance = 0
        val change = 3
        When("거리가 ${initDistance}로 초기화된 RacingCarPosition에 ${change}을 더하면") {
            val position = RacingCarDistance(initDistance)
            val moved = position + change
            Then("${change}만큼 더해진 거리를 가진 RacingCarPosition을 반환한다") {
                moved.value shouldBe initDistance + change
            }
        }
    }

    Given("초기 위치값, 후진 거리") {
        val initDistance = 5
        val change = 3
        When("거리가 ${initDistance}로 초기화된 RacingCarPosition에 ${change}을 더하면") {
            val position = RacingCarDistance(initDistance)
            val moved = position - change
            Then("${change}만큼 빠진 거리를 가진 RacingCarPosition을 반환한다") {
                moved.value shouldBe initDistance - change
            }
        }
    }
})
