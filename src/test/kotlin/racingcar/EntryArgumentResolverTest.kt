package racingcar

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.converter.EntryArgumentResolver

class EntryArgumentResolverTest : ExpectSpec({

    context("EntryArgumentResolver test") {
        expect("resolve test") {
            val resolve = EntryArgumentResolver.resolve("test1,test2,test3")

            resolve.value shouldBe listOf("test1", "test2", "test3")
        }
    }
})
