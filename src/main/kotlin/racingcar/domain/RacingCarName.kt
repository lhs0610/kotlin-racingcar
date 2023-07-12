package racingcar.domain

import racingcar.contants.ErrorType

@JvmInline
value class RacingCarName(
    private val _name: String
) {
    init {
        require(_name.isNotBlank() && _name.length <= MAX_NAME_LENGTH) {
            ErrorType.INVALID_CAR_NAME.message
        }
    }

    val name: String
        get() = _name

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
