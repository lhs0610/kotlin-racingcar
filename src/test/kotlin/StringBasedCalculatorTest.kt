import constant.StringConstant
import enums.ErrorCode
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldStartWith
import utilities.StringBasedCalculator
import utilities.StringBasedCalculatorV2

class StringBasedCalculatorTest : ExpectSpec({

    context("입력 테스트") {
        expect("수식 분리 테스트") {

            val calculator = StringBasedCalculator("1 + 3 - 2 * 4 / 8")

            calculator.numbers.size shouldBe 5
            calculator.operators.size shouldBe 4
        }

        expect("잘못된 입력값 테스트: 공백 문자열") {

            var exception = shouldThrow<IllegalArgumentException> {
                StringBasedCalculatorV2.calculate(StringConstant.EMPTY)
            }

            exception.message shouldStartWith ErrorCode.ERROR_EXPRESSION_NOT_NULL_OR_BLANK.code
        }

        expect("잘못된 입력값 테스트: null") {

            val exception = shouldThrow<IllegalArgumentException> {
                StringBasedCalculatorV2.calculate(null)
            }

            exception.message shouldStartWith ErrorCode.ERROR_EXPRESSION_NOT_NULL_OR_BLANK.code
        }

        expect("잘못된 입력값 테스트: 목록에 없는 연산 기호") {

            val exception = shouldThrow<IllegalArgumentException> {
                StringBasedCalculatorV2.calculate("1 % 4")
            }

            exception.message shouldStartWith ErrorCode.ERROR_NOT_ALLOWED_SYMBOL.code
        }


        expect("잘못된 입력값 테스트: 나누기 연산 - zero case") {

            val exception = shouldThrow<IllegalArgumentException> {
                StringBasedCalculatorV2.calculate("6 / 3 / 0")
            }

            exception.message shouldStartWith ErrorCode.ERROR_DIVIDER_CANNOT_ZERO.code
        }
    }

    context("계산 테스트") {
        expect("더하기 연산 테스트") {
            val result = StringBasedCalculatorV2.calculate("1 + 2 + 3")

            result shouldBe 6
        }

        expect("빼기 연산 테스트") {
            val result = StringBasedCalculatorV2.calculate("6 - 3")

            result shouldBe 3
        }

        expect("곱하기 연산 테스트") {
            val result = StringBasedCalculatorV2.calculate("-1 * 2 * 3")

            result shouldBe -6
        }

        expect("나누기 연산 테스트") {
            val result = StringBasedCalculatorV2.calculate("8 / 4")

            result shouldBe 2
        }

        expect("사칙 연산 테스트") {
            val result = StringBasedCalculatorV2.calculate("1 + 3 - 2 * 4 / 8")

            result shouldBe 1
        }
    }
})