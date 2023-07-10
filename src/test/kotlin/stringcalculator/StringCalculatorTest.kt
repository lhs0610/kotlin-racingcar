package stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class StringCalculatorTest : BehaviorSpec({
    Given("두 개의 숫자를 더하는 식을 문자열로 제공한다.") {
        val input = "1 + 1"

        When("문자열 계산기를 이용해 계산할 때") {
            val calculator = StringCalculator()
            val result = calculator.calculate(input)

            Then("합한 값이 나온다.") {
                result shouldBe 2
            }
        }
    }

    Given("세 개의 숫자를 더하는 식을 문자열로 제공한다.") {
        val input = "1 + 1 + 1"

        When("문자열 계산기를 이용해 계산할 때") {
            val calculator = StringCalculator()
            val result = calculator.calculate(input)

            Then("합한 값이 나온다.") {
                result shouldBe 3
            }
        }
    }

    Given("두 개의 숫자를 뺴는 식을 문자열로 제공한다.") {
        val input = "3 - 1"

        When("문자열 계산기를 이용해 계산할 때") {
            val calculator = StringCalculator()
            val result = calculator.calculate(input)

            Then("뺀 값이 나온다.") {
                result shouldBe 2
            }
        }
    }

    Given("세 개의 숫자를 뺴는 식을 문자열로 제공한다.") {
        val input = "3 - 1 - 1"

        When("문자열 계산기를 이용해 계산할 때") {
            val calculator = StringCalculator()
            val result = calculator.calculate(input)

            Then("뺀 값이 나온다.") {
                result shouldBe 1
            }
        }
    }

    Given("두 개의 숫자를 곱하는 식을 문자열로 제공한다.") {
        val input = "3 * 1"

        When("문자열 계산기를 이용해 계산할 때") {
            val calculator = StringCalculator()
            val result = calculator.calculate(input)

            Then("곱한 값이 나온다.") {
                result shouldBe 3
            }
        }
    }

    Given("세 개의 숫자를 곱하는 식을 문자열로 제공한다.") {
        val input = "3 * 2 * 2"

        When("문자열 계산기를 이용해 계산할 때") {
            val calculator = StringCalculator()
            val result = calculator.calculate(input)

            Then("곱한 값이 나온다.") {
                result shouldBe 12
            }
        }
    }

    Given("두 개의 숫자를 나누는 식을 문자열로 제공한다.") {
        val input = "4 / 2"

        When("문자열 계산기를 이용해 계산할 때") {
            val calculator = StringCalculator()
            val result = calculator.calculate(input)

            Then("나눈 값이 나온다.") {
                result shouldBe 2
            }
        }
    }

    Given("세 개의 숫자를 나누는 식을 문자열로 제공한다.") {
        val input = "18 / 2 / 3"

        When("문자열 계산기를 이용해 계산할 때") {
            val calculator = StringCalculator()
            val result = calculator.calculate(input)

            Then("나눈 값이 나온다.") {
                result shouldBe 3
            }
        }
    }

    Given("사칙연산을 모두 포함한 계산식을 문자열로 제공한다.") {
        val input = "2 + 6 * 3 - 4 / 10"

        When("문자열 계산기를 이용해 계산할 때") {
            val calculator = StringCalculator()
            val result = calculator.calculate(input)

            Then("계산한 값이 나온다.") {
                result shouldBe 2
            }
        }
    }

    Given("null 문자열을 제공한다.") {
        val input = null
        When("문자열 계산기를 이용할 때") {
            val calculator = StringCalculator()
            Then("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> { calculator.calculate(input) }
            }
        }
    }

    Given("빈 문자열을 제공한다.") {
        val input = " "
        When("문자열 계산기를 이용할 때") {
            val calculator = StringCalculator()
            Then("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> { calculator.calculate(input) }
            }
        }
    }

    Given("잘못된 연산자가 있는 식을 제공한다.") {
        val input = "1 & 5"
        When("문자열 계산기를 이용할 때") {
            val calculator = StringCalculator()
            Then("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> { calculator.calculate(input) }
            }
        }
    }
})