package utilities

class InputUtil {

    companion object {

        fun receiveIntInput(): Int {
            val origin: String = readln()
            return NumberUtil.convertStringToIntCheckNumeric(origin)
        }

    }
}