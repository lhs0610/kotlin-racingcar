class Calculator(str: String?) {

    private var num: Int = 0
    private var op: Char = '+'
    private val list: List<String>

    init {
        list = splitToList(str)
    }

    fun exec(): Int {
        for ((index, el) in list.withIndex()) {
            if (index % 2 == 0) {
                operate(op, el.toIntOrNull())
            } else {
                setOp(el)
            }
        }
        return num
    }

    private fun operate(op: Char?, num2: Int?) {
        op ?: throwIfNoOperator()
        num2 ?: throwIfNoNumber()
        when (op) {
            '+' -> num += num2!!
            '-' -> num -= num2!!
            '*' -> num *= num2!!
            '/' -> num /= num2!!
            else -> throwIfNoOperator()
        }
    }

    private fun setOp(el: String) {
        when (el) {
            "+", "-", "*", "/" -> op = el[0]
            else -> throwIfNoOperator()
        }
    }

    private fun splitToList(str: String?): List<String> {
        str ?: throwIfNotExpression()
        val list = str!!.split(" ")
        if (list.size < 3) throwIfNotExpression()
        return list
    }

    private fun throwIfNotExpression() {
        throw IllegalArgumentException("Expression Required")
    }

    private fun throwIfNoNumber() {
        throw IllegalArgumentException("Number Required")
    }

    private fun throwIfNoOperator() {
        throw IllegalArgumentException("Operator Required")
    }
}
