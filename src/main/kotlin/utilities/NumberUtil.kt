package utilities

import enums.ErrorCode

class NumberUtil {

    companion object {
        fun isOdd(value: Int): Boolean {
            return value % 2 == 1
        }

        fun convertStringToIntCheckNumeric(origin: String): Int {
            return origin.toIntOrNull() ?: throw java.lang.IllegalArgumentException("${ErrorCode.ERROR_IS_NOT_NUMERIC.code}: \'${origin}\'은 숫자가 아닙니다.")
        }
    }
}