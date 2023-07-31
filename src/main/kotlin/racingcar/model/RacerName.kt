package racingcar.model

import racingcar.constant.Message

@JvmInline
value class RacerName(val value: String) {

    init {
        require(value.length <= 5) { Message.INVALID_INPUT_VALUE_CANNOT_HIGHER_THEN_FIVE.message }
    }
}
