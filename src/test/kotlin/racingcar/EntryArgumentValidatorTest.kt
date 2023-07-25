package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.converter.EntryArgumentResolver
import racingcar.validator.EntryArgumentValidator

class EntryArgumentValidatorTest : ExpectSpec({

    context("EntryArgumentResolver test") {
        expect("validate test - valid format") {
            val validate = EntryArgumentValidator.validate("test1,test2,test3")

            validate shouldBe true
        }

        expect("validate test - invalid format 1") {
            val validate = EntryArgumentValidator.validate(",,,")

            validate shouldBe false
        }

        expect("validate test - invalid format 2") {
            val validate = EntryArgumentValidator.validate(",test2,test3")

            validate shouldBe false
        }

        expect("validate test - invalid format 3") {
            val validate = EntryArgumentValidator.validate("test2,test3,")

            validate shouldBe false
        }

        expect("validate test - racer name length > 5") {
            val validate = EntryArgumentValidator.validate("tester1,tester2")

            validate shouldBe false
        }
    }
})
