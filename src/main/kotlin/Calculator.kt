import java.util.*

class Calculator(val strValue: String) {

    val strList = LinkedList<String>()
    private var result = Number(0.0)

    init {
        if (strValue.isBlank()) {
            throw IllegalArgumentException()
        }
        strList.addAll(this.strValue.split(" "))
    }

    fun run(): Number {
        result = Number(strList[0])
        for (idx in 1 until strList.size step 2) {
            val op = strList[idx]
            val n2 = Number(strList[idx + 1])

            result = calculate(result, n2, op)
        }
        return result
    }

    private fun calculate(n1: Number, n2: Number, op: String): Number {
        return when (op) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> n1 / n2
            else -> throw IllegalArgumentException()
        }
    }
}
