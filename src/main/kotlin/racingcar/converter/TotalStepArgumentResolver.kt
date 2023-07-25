package racingcar.converter

import racingcar.model.TotalStepInput

object TotalStepArgumentResolver : InputArgumentResolver<TotalStepInput> {

    override fun resolve(input: String): TotalStepInput {
        return TotalStepInput(input.toInt())
    }
}
