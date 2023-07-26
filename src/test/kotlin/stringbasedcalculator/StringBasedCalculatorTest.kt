package stringbasedcalculator

import stringcalculator.constant.StringConstant
import stringcalculator.enums.ErrorCode
import stringcalculator.enums.Operator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import stringcalculator.component.StringBasedCalculator

class StringBasedCalculatorTest : ExpectSpec({

    context("입력 테스트") {

        expect("잘못된 입력값 테스트: 공백 문자열") {
            val exception = shouldThrow<IllegalArgumentException> {
                StringBasedCalculator.calculate(delimiter = StringConstant.BLANK, expression = StringConstant.EMPTY)
            }

            exception.message shouldStartWith ErrorCode.ERROR_EXPRESSION_NOT_NULL_OR_BLANK.code
        }

        expect("잘못된 입력값 테스트: null") {
            val exception = shouldThrow<IllegalArgumentException> {
                StringBasedCalculator.calculate(delimiter = StringConstant.BLANK, expression = null)
            }

            exception.message shouldStartWith ErrorCode.ERROR_EXPRESSION_NOT_NULL_OR_BLANK.code
        }

        expect("잘못된 입력값 테스트: 목록에 없는 연산 기호") {
            val exception = shouldThrow<IllegalArgumentException> {
                StringBasedCalculator.calculate(delimiter = StringConstant.BLANK, expression = "1 % 4")
            }

            exception.message shouldStartWith ErrorCode.ERROR_NOT_ALLOWED_SYMBOL.code
        }

        expect("잘못된 입력값 테스트: 피연산자로 끝나지 않는 수식") {
            val exception = shouldThrow<IllegalArgumentException> {
                StringBasedCalculator.calculate(delimiter = StringConstant.BLANK, expression = "1 * 4 +")
            }

            exception.message shouldStartWith ErrorCode.ERROR_OPERATOR_OPERAND_COUNT_NOT_MATCH.code
        }

        expect("잘못된 입력값 테스트: 구분자로 연산자를 사용") {
            val exception = shouldThrow<IllegalArgumentException> {
                StringBasedCalculator.calculate(delimiter = Operator.DIVIDE.operator, expression = "1 * 4")
            }

            exception.message shouldStartWith ErrorCode.ERROR_CANNOT_USE_OPERATOR_AS_DELIMITER.code
        }

        expect("잘못된 입력값 테스트: 나누기 연산 - zero case") {
            val exception = shouldThrow<IllegalArgumentException> {
                StringBasedCalculator.calculate(delimiter = StringConstant.BLANK, expression = "6 / 3 / 0")
            }

            exception.message shouldStartWith ErrorCode.ERROR_DIVIDER_CANNOT_ZERO.code
        }

        expect("입력값 테스트: 커스텀 구분자 사용") {
            val result = StringBasedCalculator.calculate(delimiter = StringConstant.HASH, expression = "1#+#2#*#4")

            result shouldBe 12
        }

        expect("입력값 테스트: 피연산자 위치에 숫자 이외의 다른 값 입력") {

            val exception = shouldThrow<IllegalArgumentException> {
                StringBasedCalculator.calculate(delimiter = StringConstant.BLANK, expression = "1 + / * 4")
            }

            exception.message shouldStartWith ErrorCode.ERROR_IS_NOT_NUMERIC.code
        }
    }

    context("계산 테스트") {
        expect("더하기 연산 테스트") {
            val result = StringBasedCalculator.calculate(delimiter = StringConstant.BLANK, expression = "1 + 2 + 3")

            result shouldBe 6
        }

        expect("빼기 연산 테스트") {
            val result = StringBasedCalculator.calculate(delimiter = StringConstant.BLANK, expression = "6 - 3")

            result shouldBe 3
        }

        expect("곱하기 연산 테스트") {
            val result = StringBasedCalculator.calculate(delimiter = StringConstant.BLANK, expression = "-1 * 2 * 3 * 4")

            result shouldBe -24
        }

        expect("나누기 연산 테스트") {
            val result = StringBasedCalculator.calculate(delimiter = StringConstant.BLANK, expression = "8 / 4")

            result shouldBe 2
        }

        expect("사칙 연산 테스트") {
            val result = StringBasedCalculator.calculate(delimiter = StringConstant.BLANK, expression = "1 + 3 - 2 * 4 / 8")

            result shouldBe 1
        }
    }
})
