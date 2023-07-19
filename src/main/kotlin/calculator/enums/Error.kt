package calculator.enums

enum class Error(
    val message: String
) {
    INVALID_OPERATOR("잘못된 연산자입니다."),
    CANNOT_BLANK_INPUT_FORMULA("수식은 공백일 수 없습니다."),
    INVALID_DENOMINATOR("잘못된 분모값입니다."),
    INVALID_TYPE_CAST_EXCEPTION("타입변환을 할 수 없습니다.")
}
