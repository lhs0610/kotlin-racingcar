package stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import stringcalculator.constants.ErrorType.INVALID_OPERATOR
import stringcalculator.enums.Operator

class OperatorTest : BehaviorSpec({
    Given("더하기 연산자를 제공한다.") {
        val input = "+"

        When("연산자로 Operator 를 찾을 때") {
            val operator = Operator.of(input)
            Then("Operator ADD를 반환한다.") {
                operator shouldBe Operator.ADD
            }
        }
    }

    Given("빼기 연산자를 제공한다.") {
        val input = "-"

        When("연산자로 Operator 를 찾을 때") {
            val operator = Operator.of(input)
            Then("Operator SUBTRACT를 반환한다.") {
                operator shouldBe Operator.SUBTRACT
            }
        }
    }

    Given("곱하기 연산자를 제공한다.") {
        val input = "*"

        When("연산자로 Operator 를 찾을 때") {
            val operator = Operator.of(input)
            Then("Operator MULTIPLE를 반환한다.") {
                operator shouldBe Operator.MULTIPLE
            }
        }
    }

    Given("나누기 연산자를 제공한다.") {
        val input = "/"

        When("연산자로 Operator 를 찾을 때") {
            val operator = Operator.of(input)
            Then("Operator DIVIDE를 반환한다.") {
                operator shouldBe Operator.DIVIDE
            }
        }
    }

    Given("잘못된 연산자를 제공한다.") {
        val input = "^"

        When("잘못된 연산자로 Operator 를 찾을 때") {
            Then("IllegalArgumentException 예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> { Operator.of(input) }
                exception.message should startWith(INVALID_OPERATOR.message)
            }
        }
    }
})