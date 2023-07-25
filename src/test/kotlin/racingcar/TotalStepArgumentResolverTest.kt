package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.converter.TotalStepArgumentResolver

class TotalStepArgumentResolverTest : ExpectSpec({

    context("TotalStepArgumentResolver test") {
        expect("resolve test") {
            val resolve = TotalStepArgumentResolver.resolve("1178")

            resolve.value shouldBe 1178
        }
    }
})
