import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculateTest : DescribeSpec({
    describe("Calculate") {
        context("덧셈식이 주어졌을 때") {
            val formula = "12 + 6"
            it("덧셈") {
                multipleCalculate(formula) shouldBe 18
            }
        }

        context("뺄셈식이 주어졌을 때") {
            val formula = "17 - 7"
            it("뺄셈") {
                multipleCalculate(formula) shouldBe 10
            }
        }


        context("곱셈식이 주어졌을 때") {
            val formula = "13 * 13"
            it("곱셈") {
                multipleCalculate(formula) shouldBe 169
            }
        }

        context("나눗셈식이 주어졌을 때") {
            val formula = "15 / 3"
            it("나눗셈") {
                multipleCalculate(formula) shouldBe 5
            }
        }

        context("공백이 주어졌을 때") {
            val formula = ""
            it("에러발생") {
                shouldThrow<IllegalArgumentException> {
                    multipleCalculate(formula)
                }
            }
        }

        context("사칙연산 기호가 아닌 경우가 주어졌을 때") {
            val formula = "17 ] 12"
            it("에러발생") {
                shouldThrow<IllegalArgumentException> {
                    multipleCalculate(formula)
                }
            }
        }

        context("사칙연산이 주어졌을 때") {
            val formula = "10 - 5 * 10 + 10 / 5"
            it("순차적으로 계산") {
                multipleCalculate(formula) shouldBe 12
            }
        }
    }
})

private fun multipleCalculate(formula: String): Int {
    validationNullOrEmpty(formula)
    val trimFormula = splitByWhiteSpace(formula)
    var answer = trimFormula[0].toInt()
    for (i in 1 until trimFormula.size step 2) {
        answer = calculate(answer, trimFormula[i + 1].toInt(), trimFormula[i])
    }
    return answer
}

fun validationNullOrEmpty(formula: String?) {
    if (formula.isNullOrBlank()) throw IllegalArgumentException()
}

private fun calculate(number1: Int, number2: Int, operator: String) =
    when (operator) {
        "+" -> number1 plus number2
        "-" -> number1 minus number2
        "*" -> number1 times number2
        "/" -> number1 div number2
        else -> throw IllegalArgumentException()
    }

private fun splitByWhiteSpace(formula: String) = formula.split(" ")

infix fun Int.plus(other: Int) = this + other

infix fun Int.minus(other: Int) = this - other

infix fun Int.times(other: Int) = this * other

infix fun Int.div(other: Int) = this / other
