package stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import java.lang.IllegalArgumentException

class OperatorTest : BehaviorSpec({
    Given("잘못된 연산자를 제공한다.") {
        val input = "^"

        When("잘못된 연산자로 Operator 를 찾을 때") {
            Then("IllegalArgumentException 예외를 던진다.") {
                shouldThrow<IllegalArgumentException> { Operator.of(input) }
            }
        }
    }
})