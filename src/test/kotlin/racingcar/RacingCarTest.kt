package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.constant.Message
import racingcar.domain.RacingCar

class RacingCarTest : BehaviorSpec({

    Given("racingCar") {
        val racingCar = RacingCar.of("Jinni", 0)
        When("레이서 이름과 거리를 생성자 인자로 RacingCar를 생성하면") {
            Then("프로퍼티에 동일한 값이 설정된 RacingCar를 반환한다") {
                racingCar.getDistance() shouldBe 0
                racingCar.getRacerName() shouldBe "Jinni"
            }
        }
        When("이동 거리가 0 인 상태에서 attemptMove 메서드를 호출하면(무조건 이동 정책 사용)") {
            racingCar.attemptMove { true }
            Then("racingCar의 이동 거리는 1이 되어야 한다") {
                racingCar.getDistance() shouldBe 1
            }
        }
        When("레이서 이름이 글자 수 제한을 초과하면") {
            val exception = shouldThrow<IllegalArgumentException> { RacingCar.of("JinniJinni", 0) }
            Then("에러가 발생한다") {
                exception.message shouldBe Message.INVALID_INPUT_VALUE_CANNOT_HIGHER_THEN_FIVE.message
            }
        }
    }
})
