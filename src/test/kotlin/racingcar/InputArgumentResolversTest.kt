package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.converter.EntryArgumentResolver
import racingcar.converter.InputArgumentResolvers
import racingcar.config.Configuration
import racingcar.model.EntryInput
import racingcar.model.TotalStepInput

class InputArgumentResolversTest : ExpectSpec({

    context("InputArgumentResolvers test") {
        expect("resolve test - EntryArgumentResolver") {
            Configuration.init()

            val resolve = InputArgumentResolvers.resolve(EntryInput::class, "JN1,JN2,JN3")

            resolve.value shouldBe listOf("JN1", "JN2", "JN3")
        }

        expect("resolve test - TotalStepArgumentResolver") {
            Configuration.init()

            val resolve = InputArgumentResolvers.resolve(TotalStepInput::class, "11034")

            resolve.value shouldBe 11034
        }
    }
})
