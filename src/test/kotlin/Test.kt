import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Test : StringSpec({
    "plus test" {
        val expression = "1 + 2 + 12 + 33"
        val cal = Calculator(expression)
        val result = cal.exec()
        result shouldBe 48
    }

    "minus test" {
        val expression = "32 - 30 - 12 - 1"
        val cal = Calculator(expression)
        val result = cal.exec()
        result shouldBe -11
    }

    "multiply test" {
        val expression = "1 * 2 * 10 * 3"
        val cal = Calculator(expression)
        val result = cal.exec()
        result shouldBe 60
    }

    "divide test" {
        val expression = "120 / 6 / 4"
        val cal = Calculator(expression)
        val result = cal.exec()
        result shouldBe 5
    }

    "null test" {
        val expression = null
        val exception = shouldThrow<IllegalArgumentException> {
            Calculator(expression)
        }
        exception.message shouldBe "Expression Required"
    }

    "empty test" {
        val expression = ""
        val exception = shouldThrow<IllegalArgumentException> {
            Calculator(expression)
        }
        exception.message shouldBe "Expression Required"
    }

    "calculating test" {
        val expression1 = "8 + 2 - 3 * 4 / 7"
        val cal1 = Calculator(expression1)
        val result1 = cal1.exec()
        result1 shouldBe 4

        val expression2 = "10 / 5 * 12 + 4 / 2 - 10"
        val cal2 = Calculator(expression2)
        val result2 = cal2.exec()
        result2 shouldBe 4
    }
})
