package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCar

class RacingCarTest : BehaviorSpec({

    Given("레이서 이름, 초기 위치값") {
        val racerName = "Jinni"
        val initDistance = 0
        When("주어진 인자로 RacingCar를 생성하면") {
            val racingCar = RacingCar.of(racerName, initDistance)
            Then("프로퍼티에 동일한 값이 설정된 RacingCar를 반환한다") {
                racingCar.getRacerName() shouldBe racerName
                racingCar.getDistance() shouldBe initDistance
            }
        }
    }

    Given("글자 수 제한을 초과하는 레이서 이름, 초기 위치값") {
        val racerName = "JinniJinni"
        val initDistance = 0
        When("주어진 인자로 RacingCar를 생성하면") {
            Then("예외가 발생한다") {
                shouldThrow<IllegalArgumentException> { RacingCar.of(racerName, initDistance) }
            }
        }
    }

    Given("RacingCar") {
        val racerName = "Jinni"
        val initDistance = 0
        val offset = 1

        val racingCar = RacingCar.of(racerName, initDistance)
        When("거리가 ${initDistance}로 초기화된 RacingCar의 attemptMove 메서드를 호출하면(무조건 이동 정책 사용)") {
            racingCar.attemptMove { true }

            val result = initDistance + offset
            Then("racingCar의 이동 거리는 ${result}이 되어야 한다") {
                racingCar.getDistance() shouldBe result
            }
        }
    }
})
