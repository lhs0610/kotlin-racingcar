package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.converter.EntryArgumentResolver

class EntryArgumentResolverTest : BehaviorSpec({

    Given("참가자 정보 문자열 입력") {
        val input = "test1,test2,test3"
        When("입력된 값으로 EntryArgumentResolver의 resolve메서드를 호출하면") {
            val resolve = EntryArgumentResolver.resolve(input)
            Then("분리된 문자열 리스트를 반환한다") {
                resolve.value shouldBe listOf("test1", "test2", "test3")
            }
        }
    }
})
