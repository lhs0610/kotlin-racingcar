package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.validator.EntryArgumentValidator

class EntryArgumentValidatorTest : BehaviorSpec({

    Given("조건을 충족하는 문자열 입력") {
        val input = "test1,test2,test3"
        When("입력된 값으로 EntryArgumentValidator의 validate 메서드를 호출하면") {
            val validate = EntryArgumentValidator.validate(input)
            Then("참을 반환한다") {
                validate shouldBe true
            }
        }
    }

    Given("조건을 충족하지 못하는 문자열 입력 1") {
        val input = ",,,"
        When("입력된 값으로 EntryArgumentValidator의 validate 메서드를 호출하면") {
            val validate = EntryArgumentValidator.validate(input)
            Then("거짓을 반환한다") {
                validate shouldBe false
            }
        }
    }

    Given("조건을 충족하지 못하는 문자열 입력 2") {
        val input = ",test2,test3"
        When("입력된 값으로 EntryArgumentValidator의 validate 메서드를 호출하면") {
            val validate = EntryArgumentValidator.validate(input)
            Then("거짓을 반환한다") {
                validate shouldBe false
            }
        }
    }

    Given("조건을 충족하지 못하는 문자열 입력 3") {
        val input = "test2,test3,"
        When("입력된 값으로 EntryArgumentValidator의 validate 메서드를 호출하면") {
            val validate = EntryArgumentValidator.validate(input)
            Then("거짓을 반환한다") {
                validate shouldBe false
            }
        }
    }

    Given("조건을 충족하지 못하는 문자열 입력 4") {
        val input = "tester1,tester2"
        When("입력된 값으로 EntryArgumentValidator의 validate 메서드를 호출하면") {
            val validate = EntryArgumentValidator.validate(input)
            Then("거짓을 반환한다") {
                validate shouldBe false
            }
        }
    }
})
