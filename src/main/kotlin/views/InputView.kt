package views

import utilities.InputUtil

class InputView {
    companion object {
        fun inputRacingCarQuantity(): Int {
            println("자동차 대수는 몇 대인가요?")
            return InputUtil.receiveIntInput()
        }

        fun inputTotalStep(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return InputUtil.receiveIntInput()
        }
    }
}