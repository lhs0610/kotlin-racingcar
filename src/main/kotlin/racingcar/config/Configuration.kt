package racingcar.config

import racingcar.converter.EntryArgumentResolver
import racingcar.converter.InputArgumentResolvers
import racingcar.converter.TotalStepArgumentResolver
import racingcar.model.EntryInput
import racingcar.model.TotalStepInput
import racingcar.validator.EntryArgumentValidator
import racingcar.validator.InputArgumentValidators
import racingcar.validator.TotalStepArgumentValidator

data class Configuration(
    val resolvers: InputArgumentResolvers,
    val validators: InputArgumentValidators
) {
    companion object {
        fun getRacingGameConfig(): Configuration {
            return Configuration(getRacingGameInputResolvers(), getRacingGameInputValidators())
        }

        private fun getRacingGameInputResolvers(): InputArgumentResolvers {
            val resolvers = InputArgumentResolvers()
            resolvers.addResolver(EntryInput::class, EntryArgumentResolver)
            resolvers.addResolver(TotalStepInput::class, TotalStepArgumentResolver)
            return resolvers
        }

        private fun getRacingGameInputValidators(): InputArgumentValidators {
            val validators = InputArgumentValidators()
            validators.addValidator(EntryInput::class, EntryArgumentValidator)
            validators.addValidator(TotalStepInput::class, TotalStepArgumentValidator)
            return validators
        }
    }
}
