package racingcar.utils

class RaceUtils {

    companion object {
        fun randomNumber() = (1..9).random()

        fun moveOrNot(moveConditionNumber: Int, number: Int) = moveConditionNumber <= number
    }
}
