import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

const val successStrValue = "2 + 3 * 4 / 2"
const val failureStrValue = "2 + 3 * 4 2 2"

@DisplayName("Step2 : 문자열 계산기")
class CalculatorTest : FunSpec({

    test("사칙연산 문자열을 입력 받는 계산기를 생성한다.") {
        val actual = Calculator(successStrValue)
        actual.shouldNotBeNull()
        actual.strValue shouldBe successStrValue
    }

    test("사칙연산 문자열을 분리한다.") {
        val actual = Calculator(successStrValue)
        actual.strList.size shouldBe 7
        actual.strList.poll() shouldBe "2"
        actual.strList.poll() shouldBe "+"
        actual.strList.poll() shouldBe "3"
        actual.strList.poll() shouldBe "*"
        actual.strList.poll() shouldBe "4"
        actual.strList.poll() shouldBe "/"
        actual.strList.poll() shouldBe "2"
    }

    test("숫자 객체를 구현한다.") {
        val actual = Number("2")
        actual.value shouldBe 2
        actual.value shouldNotBe "3"
    }

    test("각 사칙연산에 대한 오퍼레이터를 구현한다.") {
        val n1 = Number(3.0)
        val n2 = Number(2.0)
        (n1 + n2).value shouldBe 5.0
        (n1 - n2).value shouldBe 1.0
        (n1 * n2).value shouldBe 6.0
        (n1 / n2).value shouldBe 1.5
    }

    test("사칙연산 문자열에 대한 올바른 결과값을 출력한다.") {
        val actual = Calculator(successStrValue).run()
        actual.value shouldBe 10
    }

    test("사칙연산 순서에 올바르지 않는 문자열을 구별한다.") {
        shouldThrow<IllegalArgumentException> {
            Calculator(failureStrValue).run()
        }
    }
})