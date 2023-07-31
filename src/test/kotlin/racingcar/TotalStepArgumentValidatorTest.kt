package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.validator.TotalStepArgumentValidator

class TotalStepArgumentValidatorTest : BehaviorSpec({

    Given("변환이 되고 조건을 충족하는 정수 문자열 입력") {
        val input = "102"
        When("입력된 값으로 TotalStepArgumentValidator의 validate 메서드를 호출하면") {
            val validate = TotalStepArgumentValidator.validate(input)
            Then("참이 반환된다") {
                validate shouldBe true
            }
        }
    }

    Given("정수 포맷이 아닌 문자열 입력") {
        val input = "abc"
        When("입력된 값으로 TotalStepArgumentValidator의 validate 메서드를 호출하면") {
            val validate = TotalStepArgumentValidator.validate(input)
            Then("거짓이 반환된다") {
                validate shouldBe false
            }
        }
    }

    Given("조건을 충족하지 못하는 정수 문자열 입력") {
        val input = "0"
        When("입력된 값으로 TotalStepArgumentValidator의 validate 메서드를 호출하면") {
            val validate = TotalStepArgumentValidator.validate(input)
            Then("거짓이 반환된다") {
                validate shouldBe false
            }
        }
    }
})
