package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.converter.TotalStepArgumentResolver

class TotalStepArgumentResolverTest : ExpectSpec({

    context("TotalStepArgumentResolver test") {
        expect("validate test - numeric string") {
            val validate = TotalStepArgumentResolver.validate("102")

            validate shouldBe true
        }

        expect("validate test - non-numeric string") {
            val validate = TotalStepArgumentResolver.validate("abc")

            validate shouldBe false
        }

        expect("validate test - value < 1") {
            val validate = TotalStepArgumentResolver.validate("0")

            validate shouldBe false
        }

        expect("validate test - value > 0") {
            val validate = TotalStepArgumentResolver.validate("1")

            validate shouldBe true
        }

        expect("resolve test") {
            val resolve = TotalStepArgumentResolver.resolve("1178")

            resolve.value shouldBe 1178
        }
    }
})
