package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.converter.EntryArgumentResolver
import racingcar.converter.InputArgumentResolvers
import racingcar.converter.TotalStepArgumentResolver
import racingcar.model.EntryInput
import racingcar.model.TotalStepInput

class InputArgumentResolversTest : BehaviorSpec({

    Given("EntryInput, TotalStepInput타입 처리기를 포함한 InputArgumentResolvers") {
        val resolvers = InputArgumentResolvers()
        resolvers.addResolver(EntryInput::class, EntryArgumentResolver)
        resolvers.addResolver(TotalStepInput::class, TotalStepArgumentResolver)

        When("EntryInput용 타입 선언과 입력으로 InputArgumentResolvers의 resolve메서드를 호출하면") {
            val input = "JN1,JN2,JN3"
            val resolve = resolvers.resolve(EntryInput::class, input)
            Then("분리된 문자열 리스트를 반환한다") {
                resolve.value shouldBe listOf("JN1", "JN2", "JN3")
            }
        }

        When("TotalStepInput 타입 선언과 입력으로 InputArgumentResolvers의 resolve메서드를 호출하면") {
            val input = "11034"
            val resolve = resolvers.resolve(TotalStepInput::class, input)
            Then("정수로 변환된 값을 반환한다") {
                resolve.value shouldBe 11034
            }
        }
    }
})
