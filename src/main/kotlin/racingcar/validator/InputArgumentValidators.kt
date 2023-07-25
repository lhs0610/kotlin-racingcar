package racingcar.validator

import racingcar.constant.Message
import racingcar.model.EntryInput
import racingcar.model.TotalStepInput
import kotlin.reflect.KClass

object InputArgumentValidators {
    private val validatorMap = mutableMapOf<KClass<*>, InputArgumentValidator>()

    init {
        addValidator(EntryInput::class, EntryArgumentValidator)
        addValidator(TotalStepInput::class, TotalStepArgumentValidator)
    }

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
