import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

const val successStrValue = "2 + 3 * 4 / 2"

@DisplayName("Step2 : 문자열 계산기")
class CalculatorTest : FunSpec({

    test("사칙연산 문자열을 입력 받는 계산기를 생성한다.") {
        val actual = Calculator(successStrValue)
        actual.shouldNotBeNull()
        actual.strValue shouldBe successStrValue
    }

    test("사칙연산 문자열을 분리한다.") {
        val actual = Calculator(successStrValue)
        actual.strQueue.size shouldBe 7
        actual.strQueue.poll() shouldBe "2"
        actual.strQueue.poll() shouldBe "+"
        actual.strQueue.poll() shouldBe "3"
        actual.strQueue.poll() shouldBe "*"
        actual.strQueue.poll() shouldBe "4"
        actual.strQueue.poll() shouldBe "/"
        actual.strQueue.poll() shouldBe "2"
    }

    test("숫자 객체를 구현한다.") {
        val actual = Number("2")
        actual.value shouldBe 2
        actual.value shouldNotBe "3"
    }

    }

    test("슷자가 아닌 문자의 입력을 구별한다.") {

    }

    test("사칙연산 순서에 올바르지 않는 문자열을 구별한다.") {

    }

    test("사칙연산 문자열에 대한 올바른 결과값을 출력한다.") {

    }
})