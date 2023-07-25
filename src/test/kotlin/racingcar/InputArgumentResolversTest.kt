package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.converter.InputArgumentResolvers
import racingcar.model.EntryInput
import racingcar.model.TotalStepInput

class InputArgumentResolversTest : ExpectSpec({

    context("InputArgumentResolvers test") {
        expect("resolve test - EntryArgumentResolver") {
            val resolve = InputArgumentResolvers.resolve(EntryInput::class, "JN1,JN2,JN3")

            resolve.value shouldBe listOf("JN1", "JN2", "JN3")
        }

        expect("resolve test - TotalStepArgumentResolver") {
            val resolve = InputArgumentResolvers.resolve(TotalStepInput::class, "11034")

            resolve.value shouldBe 11034
        }
    }
})
