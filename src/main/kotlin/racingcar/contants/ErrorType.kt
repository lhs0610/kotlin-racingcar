package racingcar.contants

enum class ErrorType(
    val message: String
) {
    INVALID_NUMBER("Invalid number."),
    INVALID_MOVED_DISTANCE("Invalid moved distance.")
}