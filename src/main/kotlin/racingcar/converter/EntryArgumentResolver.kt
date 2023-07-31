package racingcar.converter

import racingcar.domain.StringSplitter
import racingcar.model.EntryInput

object EntryArgumentResolver : InputArgumentResolver<EntryInput> {

    override fun resolve(input: String): EntryInput {
        return EntryInput(StringSplitter.split(input))
    }
}
