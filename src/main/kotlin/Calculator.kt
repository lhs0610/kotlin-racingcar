import java.util.*

class Calculator(val strValue: String) {

    val strQueue: Queue<String> = LinkedList()

    init {
        val splitStr = this.strValue.split(" ")
        this.strQueue.addAll(splitStr)
    }
}