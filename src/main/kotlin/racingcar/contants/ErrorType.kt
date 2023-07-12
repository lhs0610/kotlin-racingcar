package racingcar.contants

enum class ErrorType(
    val message: String
) {
    INVALID_STEP_NUMBER("Invalid step number."),
    INVALID_MOVED_DISTANCE("Invalid moved distance."),
    INVALID_CAR_NAME("Invalid car name."),
    INVALID_CAR_NUMBER("Invalid car number.")
}
