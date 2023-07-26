import component.MathExpression
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import util.calculate
import java.lang.ArithmeticException

class Test : StringSpec({

    "plus test" {
        val inp = "1 + 2 + 12 + 33"
        val mathExpression = MathExpression(inp)
        val result = calculate(mathExpression)
        result shouldBe 48
    }

    "minus test" {
        val inp = "32 - 30 - 12 - 1"
        val mathExpression = MathExpression(inp)
        val result = calculate(mathExpression)
        result shouldBe -11
    }

    "multiply test" {
        val inp = "1 * 2 * 10 * 3"
        val mathExpression = MathExpression(inp)
        val result = calculate(mathExpression)
        result shouldBe 60
    }

    "divide test" {
        val inp = "120 / 6 / 4"
        val mathExpression = MathExpression(inp)
        val result = calculate(mathExpression)
        result shouldBe 5
    }

    "null or empty test" {
        val inp1 = null
        val exception1 = shouldThrow<IllegalArgumentException> {
            MathExpression(inp1)
        }
        exception1.message shouldBe "Invalid Expression"

        val inp2 = ""
        val exception2 = shouldThrow<IllegalArgumentException> {
            MathExpression(inp2)
        }
        exception2.message shouldBe "Invalid Expression"
    }

    "exception with 0 test" {
        val inp1 = "0 / 1"
        val mathExpression1 = MathExpression(inp1)
        val result1 = calculate(mathExpression1)
        result1 shouldBe 0

        val inp2 = "1 / 0"
        val mathExpression2 = MathExpression(inp2)
        shouldThrow<ArithmeticException> {
            calculate(mathExpression2)
        }
    }

    "continuous input test" {
        val inp1 = "1 +1 - 1"
        val exception1 = shouldThrow<IllegalArgumentException> {
            MathExpression(inp1)
        }
        exception1.message shouldBe "Invalid Expression"

        val inp2 = "1+ 1 - 1"
        val exception2 = shouldThrow<IllegalArgumentException> {
            MathExpression(inp2)
        }
        exception2.message shouldBe "Invalid Expression"
    }

    "continuous number/operator test" {
        val inp1 = "1 2 + 3 - 2"
        val exception1 = shouldThrow<IllegalArgumentException> {
            MathExpression(inp1)
        }
        exception1.message shouldBe "Invalid Expression"

        val inp2 = "1 + 3 / - 2"
        val exception2 = shouldThrow<IllegalArgumentException> {
            MathExpression(inp2)
        }
        exception2.message shouldBe "Invalid Expression"
    }

    "invalid starter/ender test" {
        val inp1 = "+ 2 + 3"
        val exception1 = shouldThrow<IllegalArgumentException> {
            MathExpression(inp1)
        }
        exception1.message shouldBe "Invalid Expression"

        val inp2 = "1 + 3 -"
        val exception2 = shouldThrow<IllegalArgumentException> {
            MathExpression(inp2)
        }
        exception2.message shouldBe "Invalid Expression"
    }

    "correct expression test" {
        val inp1 = "8 + 2 - 3 * 4 / 7"
        val mathExpression1 = MathExpression(inp1)
        val result1 = calculate(mathExpression1)
        result1 shouldBe 4

        val inp2 = "10 / 5 * 12 + 4 / 2 - 10"
        val mathExpression2 = MathExpression(inp2)
        val result2 = calculate(mathExpression2)
        result2 shouldBe 4
    }
})
