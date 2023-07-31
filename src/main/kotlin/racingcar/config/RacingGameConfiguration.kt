package racingcar.config

import racingcar.converter.EntryArgumentResolver
import racingcar.converter.InputArgumentResolvers
import racingcar.converter.TotalStepArgumentResolver
import racingcar.model.EntryInput
import racingcar.model.TotalStepInput
import racingcar.validator.EntryArgumentValidator
import racingcar.validator.InputArgumentValidators
import racingcar.validator.TotalStepArgumentValidator

object RacingGameConfiguration : Configuration {

    private val inputArgumentResolvers: InputArgumentResolvers = InputArgumentResolvers()
    private val inputArgumentValidators: InputArgumentValidators = InputArgumentValidators()

    init {
        inputArgumentResolvers.addResolver(EntryInput::class, EntryArgumentResolver)
        inputArgumentResolvers.addResolver(TotalStepInput::class, TotalStepArgumentResolver)

        inputArgumentValidators.addValidator(EntryInput::class, EntryArgumentValidator)
        inputArgumentValidators.addValidator(TotalStepInput::class, TotalStepArgumentValidator)
    }

    override fun getResolvers(): InputArgumentResolvers {
        return inputArgumentResolvers
    }

    override fun getValidators(): InputArgumentValidators {
        return inputArgumentValidators
    }
}
