package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.converter.TotalStepArgumentResolver

class TotalStepArgumentResolverTest : BehaviorSpec({

    Given("스텝 수 문자열 입력") {
        val input = "1178"
        When("입력된 값으로 TotalStepArgumentResolver의 resolve 메서드를 호출하면") {
            val resolve = TotalStepArgumentResolver.resolve(input)
            Then("정수로 변환된 값을 반환한다") {
                resolve.value shouldBe 1178
            }
        }
    }
})
