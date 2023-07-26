package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.model.EntryInput
import racingcar.model.TotalStepInput
import racingcar.validator.InputArgumentValidators
import racingcar.validator.TotalStepArgumentValidator

class InputArgumentValidatorsTest : ExpectSpec({

    context("InputArgumentValidators test") {
        context("EntryArgumentValidator") {
            val entryInputType = EntryInput::class

            expect("validate test - valid format") {
                val validate = InputArgumentValidators.validate(entryInputType, "test1,test2,test3")

                validate shouldBe true
            }

            expect("validate test - invalid format 1") {
                val validate = InputArgumentValidators.validate(entryInputType, ",,,")

                validate shouldBe false
            }

            expect("validate test - invalid format 2") {
                val validate = InputArgumentValidators.validate(entryInputType, ",test2,test3")

                validate shouldBe false
            }

            expect("validate test - invalid format 3") {
                val validate = InputArgumentValidators.validate(entryInputType, "test2,test3,")

                validate shouldBe false
            }

            expect("validate test - racer name length > 5") {
                val validate = InputArgumentValidators.validate(entryInputType, "tester1,tester2")

                validate shouldBe false
            }
        }

        context("TotalStepArgumentValidator") {
            val totalStepInputType = TotalStepInput::class

            expect("validate test - numeric string") {
                val validate = InputArgumentValidators.validate(totalStepInputType, "102")

                validate shouldBe true
            }

            expect("validate test - non-numeric string") {
                val validate = InputArgumentValidators.validate(totalStepInputType, "abc")

                validate shouldBe false
            }

            expect("validate test - value < 1") {
                val validate = InputArgumentValidators.validate(totalStepInputType, "0")

                validate shouldBe false
            }

            expect("validate test - value > 0") {
                val validate = InputArgumentValidators.validate(totalStepInputType, "1")

                validate shouldBe true
            }
        }
    }
})
