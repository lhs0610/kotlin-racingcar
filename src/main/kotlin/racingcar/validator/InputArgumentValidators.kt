package racingcar.validator

import racingcar.constant.Message
import kotlin.reflect.KClass

class InputArgumentValidators {
    private val validatorMap = mutableMapOf<KClass<*>, InputArgumentValidator>()

    fun <T : Any> validate(type: KClass<T>, value: String): Boolean {
        require(validatorMap.isNotEmpty() && validatorMap.containsKey(type)) { Message.ERROR_MATCH_RESOLVER_NOT_EXIST.message }
        val validator = validatorMap[type]
        require(validator != null) { Message.ERROR_NULL_RESOLVER_OBJECT.message }

        return validator.validate(value)
    }

    fun addValidator(key: KClass<*>, resolver: InputArgumentValidator) {
        validatorMap[key] = resolver
    }
}
