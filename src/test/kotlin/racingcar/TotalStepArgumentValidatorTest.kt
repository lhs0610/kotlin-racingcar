package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.validator.TotalStepArgumentValidator

class TotalStepArgumentValidatorTest : ExpectSpec({

    context("TotalStepArgumentValidator test") {
        expect("validate test - numeric string") {
            val validate = TotalStepArgumentValidator.validate("102")

            validate shouldBe true
        }

        expect("validate test - non-numeric string") {
            val validate = TotalStepArgumentValidator.validate("abc")

            validate shouldBe false
        }

        expect("validate test - value < 1") {
            val validate = TotalStepArgumentValidator.validate("0")

            validate shouldBe false
        }

        expect("validate test - value > 0") {
            val validate = TotalStepArgumentValidator.validate("1")

            validate shouldBe true
        }
    }
})
