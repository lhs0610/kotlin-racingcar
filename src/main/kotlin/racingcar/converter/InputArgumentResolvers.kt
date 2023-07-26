package racingcar.converter

import racingcar.constant.Message
import kotlin.reflect.KClass
import kotlin.reflect.cast

class InputArgumentResolvers {
    private val resolverMap = mutableMapOf<KClass<*>, InputArgumentResolver<*>>()

    fun <T : Any> resolve(type: KClass<T>, value: String): T {
        require(resolverMap.isNotEmpty() && resolverMap.containsKey(type)) { Message.ERROR_MATCH_RESOLVER_NOT_EXIST.message }
        val resolver = resolverMap[type]
        require(resolver != null) { Message.ERROR_NULL_RESOLVER_OBJECT.message }
        val resolved = resolver.resolve(value)

        return type.cast(resolved)
    }

    fun addResolver(key: KClass<*>, resolver: InputArgumentResolver<*>) {
        resolverMap[key] = resolver
    }
}
