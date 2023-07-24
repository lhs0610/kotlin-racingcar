package racingcar.config

import racingcar.converter.EntryArgumentResolver
import racingcar.converter.InputArgumentResolvers
import racingcar.converter.TotalStepArgumentResolver
import racingcar.model.EntryInput
import racingcar.model.TotalStepInput

object Configuration {

    fun init() {
        InputArgumentResolvers.addResolver(EntryInput::class, EntryArgumentResolver())
        InputArgumentResolvers.addResolver(TotalStepInput::class, TotalStepArgumentResolver())
    }
}
