package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.converter.TotalStepArgumentResolver
import racingcar.domain.RacingCarContainer
import racingcar.model.RacingCarSetting

class TotalStepArgumentResolverTest : ExpectSpec({

    context("TotalStepArgumentResolver test") {
        expect("validate test - numeric string") {
            val resolver = TotalStepArgumentResolver()
            val validate = resolver.validate("102")

            validate shouldBe true
        }

        expect("validate test - non-numeric string") {
            val resolver = TotalStepArgumentResolver()
            val validate = resolver.validate("abc")

            validate shouldBe false
        }

        expect("validate test - value < 1") {
            val resolver = TotalStepArgumentResolver()
            val validate = resolver.validate("0")

            validate shouldBe false
        }

        expect("validate test - value > 0") {
            val resolver = TotalStepArgumentResolver()
            val validate = resolver.validate("1")

            validate shouldBe true
        }

        expect("resolve test") {
            val resolver = TotalStepArgumentResolver()
            val resolve = resolver.resolve("1178")

            resolve.value shouldBe 1178
        }
    }
})
