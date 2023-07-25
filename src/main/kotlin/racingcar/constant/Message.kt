package racingcar.constant

enum class Message(val message: String) {
    INPUT_PARAMETER_QUANTITY("자동차 대수는 몇 대인가요?"),
    INPUT_PARAMETER_ENTRY("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    INPUT_PARAMETER_TOTAL_STEP("시도할 횟수는 몇 회인가요?"),
    INVALID_INPUT_FORMAT_NOT_INTEGER("입력한 데이터가 정수 포맷이 아닙니다. 재입력해주세요."),
    INVALID_INPUT_FORMAT_CANNOT_SPLIT("쉼표로 구분될 수 없는 데이터를 입력했습니다. 재입력해주세요."),
    INVALID_INPUT_VALUE_CANNOT_LOWER_THEN_ZERO("입력한 데이터가 0보다 작습니다. 재입력해주세요."),
    INVALID_INPUT_VALUE_CANNOT_HIGHER_THEN_FIVE("레이서의 이름은 5글자를 초과할 수 없습니다. 재입력해주세요."),
    INVALID_INPUT_VALUE_DUPLICATE_NAME_EXIST("중복된 레이서 이름이 존재합니다. 재입력해주세요."),
    ERROR_MATCH_RESOLVER_NOT_EXIST("해당하는 타입에 매칭되는 변환기가 존재하지 않습니다."),
    ERROR_NULL_RESOLVER_OBJECT("인수 변환기가 null 입니다.");
}
