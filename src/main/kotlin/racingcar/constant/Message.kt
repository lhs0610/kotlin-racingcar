package racingcar.constant

enum class Message(val message: String) {
    INPUT_PARAMETER_QUANTITY("자동차 대수는 몇 대인가요?"),
    INPUT_PARAMETER_TOTAL_STEP("시도할 횟수는 몇 회인가요?"),
    INVALID_INPUT_FORTMAT("입력한 데이터가 정수 포맷이 아닙니다. 재입력해주세요"),
    INVALID_INPUT_VALUE("입력한 데이터가 0보다 작습니다. 재입력해주세요");
}