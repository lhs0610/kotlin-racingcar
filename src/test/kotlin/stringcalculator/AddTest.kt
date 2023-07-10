package stringcalculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class AddTest : BehaviorSpec({
    Given("두 개의 숫자를 제공한다.") {
        val first = 5
        val second = 4

        When("문자열 계산기를 이용해 두 개의 숫자를 더 했을 때") {
            val calculator = StringCalculator()
            val result = calculator.add(first, second)

            Then("합한 값이 나온다.") {
                result shouldBe first + second
            }
        }
    }
})