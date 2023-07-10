package stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith
import stringcalculator.constants.ErrorType.INVALID_OPERATOR
import stringcalculator.enums.Operator

class OperatorTest : BehaviorSpec({
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