package enums

enum class Operators(val operator: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun getOperators(): List<String> {
            return enumValues<Operators>().map {
                it.operator
            }.toList()
        }
    }
}