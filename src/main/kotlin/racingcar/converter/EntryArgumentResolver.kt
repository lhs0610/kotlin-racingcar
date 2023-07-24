package racingcar.converter

import racingcar.constant.Message
import racingcar.domain.StringSplitter
import racingcar.model.EntryInput

class EntryArgumentResolver : InputArgumentResolver<EntryInput> {

    override fun validate(input: String): Boolean {
        val split = StringSplitter.split(input)
        if (split.any { it == BLANK }) {
            println(Message.INVALID_INPUT_FORTMAT_CANNOT_SPLIT.message)
            return false
        }

        if (split.map { it.length }.any { value -> value > 5 }) {
            println(Message.INVALID_INPUT_VALUE_CANNOT_HIGHER_THEN_FIVE.message)
            return false
        }

        val originSize = split.size
        val distinctSize = split.distinct().size
        if (originSize != distinctSize) {
            println(Message.INVALID_INPUT_VALUE_DUPLICATE_NAME_EXIST.message)
            return false
        }

        return true
    }

    override fun resolve(input: String): EntryInput {
        return EntryInput(StringSplitter.split(input))
    }

    companion object {
        private const val BLANK = ""
    }
}
