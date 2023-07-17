package utilities

class InputUtil {

    companion object {

        fun receiveInput(): Int {
            val origin: String = readln()
            return NumberUtil.convertStringToIntCheckNumeric(origin)
        }

    }
}