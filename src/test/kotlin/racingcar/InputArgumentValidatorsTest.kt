package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import racingcar.model.EntryInput
import racingcar.model.TotalStepInput
import racingcar.validator.EntryArgumentValidator
import racingcar.validator.InputArgumentValidators
import racingcar.validator.TotalStepArgumentValidator

class InputArgumentValidatorsTest : BehaviorSpec({

    Given("EntryInput, TotalStepInput타입 처리기를 포함한 InputArgumentValidators") {
        val validators = InputArgumentValidators()
        validators.addValidator(EntryInput::class, EntryArgumentValidator)
        validators.addValidator(TotalStepInput::class, TotalStepArgumentValidator)

        When("EntryInput용 타입 선언과 조건을 충족하는 입력으로 InputArgumentValidators의 validate메서드를 호출하면") {
            val input = "JN1,JN2,JN3"
            val validate = validators.validate(EntryInput::class, input)
            Then("참이 반환된다") {
                validate shouldBe true
            }
        }

        When("TotalStepInput 타입 선언과 조건을 충족하는 입력으로 InputArgumentValidators의 validate메서드를 호출하면") {
            val input = "11034"
            val validate = validators.validate(TotalStepInput::class, input)
            Then("참이 반환된다") {
                validate shouldBe true
            }
        }
    }
})
