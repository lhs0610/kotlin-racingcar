package racingcar.view

import racingcar.constant.Message
import racingcar.converter.InputArgumentResolvers
import racingcar.model.EntryInput
import racingcar.model.TotalStepInput
import racingcar.model.UserInput
import racingcar.validator.InputArgumentValidators
import kotlin.reflect.KClass

object InputView {

    fun getUserInput(): UserInput {
        val entryInput = getCLIInput(EntryInput::class, Message.INPUT_PARAMETER_ENTRY.message)
        val totalStepInput = getCLIInput(TotalStepInput::class, Message.INPUT_PARAMETER_TOTAL_STEP.message)

        return UserInput(entryInput, totalStepInput)
    }

    private fun <T : Any> getCLIInput(type: KClass<T>, message: String): T {
        println(message)
        var input = readln()
        while (!InputArgumentValidators.validate(type, input)) {
            input = readln()
        }
        return InputArgumentResolvers.resolve(type, input)
    }
}
