package enums

enum class Operator(val operator: String, val calculation: (Int, Int) -> Int) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLY("*", { left, right -> left * right }),
    DIVIDE("/", {
            left, right -> require(right != 0) { "${ErrorCode.ERROR_DIVIDER_CANNOT_ZERO.code }: 나누는 수는 0이 될 수 없습니다." }
            left / right
        }
    );

    companion object {
        private val mapping = enumValues<Operator>().associate { it.operator to it.calculation }

        fun getMapping(): Map<String, (Int, Int) -> Int> {
            return mapping
        }

        fun calculate(operator: String, left: Int, right: Int): Int {
            require(mapping.containsKey(operator)) { "${ErrorCode.ERROR_NOT_ALLOWED_SYMBOL.code}: 허용되지 않은 연산 기호 \'${operator}\'가 포함되어 있습니다." }

            val calculation = mapping[operator]

            return calculation!!(left, right)
        }
    }
}