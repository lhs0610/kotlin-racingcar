package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.converter.EntryArgumentResolver

class EntryArgumentResolverTest : ExpectSpec({

    context("EntryArgumentResolver test") {
        expect("validate test - valid format") {
            val validate = EntryArgumentResolver.validate("test1,test2,test3")

            validate shouldBe true
        }

        expect("validate test - invalid format 1") {
            val validate = EntryArgumentResolver.validate(",,,")

            validate shouldBe false
        }

        expect("validate test - invalid format 2") {
            val validate = EntryArgumentResolver.validate(",test2,test3")

            validate shouldBe false
        }

        expect("validate test - invalid format 3") {
            val validate = EntryArgumentResolver.validate("test2,test3,")

            validate shouldBe false
        }

        expect("validate test - racer name length > 5") {
            val validate = EntryArgumentResolver.validate("tester1,tester2")

            validate shouldBe false
        }

        expect("resolve test") {
            val resolve = EntryArgumentResolver.resolve("test1,test2,test3")

            resolve.value shouldBe listOf("test1", "test2", "test3")
        }
    }
})
