package racingcar.config

import racingcar.converter.InputArgumentResolvers
import racingcar.validator.InputArgumentValidators

interface Configuration {
    fun getResolvers(): InputArgumentResolvers
    fun getValidators(): InputArgumentValidators
}