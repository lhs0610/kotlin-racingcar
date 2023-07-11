package enums

enum class Operator(val operator: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun getOperators(): List<String> {
            return enumValues<Operator>().map {
                it.operator
            }.toList()
        }
    }
}