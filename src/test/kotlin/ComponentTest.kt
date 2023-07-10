import constant.StringConstant
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import utilities.StringBasedCalculator
import kotlin.math.exp

class ComponentTest : ExpectSpec({

    context("component test: StringBasedCalculator") {
        expect("수식 분리 테스트") {

            val calculator = StringBasedCalculator("1 + 3 - 2 * 4 / 8")

            println(calculator.numbers)
            println(calculator.operators)

            (calculator.numbers.size ?: 0) shouldBe 5
            (calculator.operators.size ?: 0) shouldBe 4
        }

        expect("잘못된 입력값 테스트: 공백 문자열") {

            val calculator = StringBasedCalculator(StringConstant.EMPTY)
        }

        expect("잘못된 입력값 테스트: null") {

            val calculator = StringBasedCalculator(null)
        }

        expect("더하기 연산 테스트") {

            val calculator = StringBasedCalculator("1 + 2 + 3")
            val result = calculator.calculate()

            println(result)

            result shouldBe 6
        }

        expect("빼기 연산 테스트") {

            val calculator = StringBasedCalculator("6 - 3")
            val result = calculator.calculate()

            println(result)

            result shouldBe 3
        }

        expect("곱하기 연산 테스트") {

            val calculator = StringBasedCalculator("-1 * 2 * 3")
            val result = calculator.calculate()

            println(result)

            result shouldBe -6
        }
    }
})