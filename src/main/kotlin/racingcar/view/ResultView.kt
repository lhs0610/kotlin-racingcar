package racingcar.view

import racingcar.RacingCar

class ResultView {
    companion object {
        fun matchView(racingCarList: List<RacingCar>) {
            for (racingCar in racingCarList) {
                draw(racingCar.moveCount)
            }
        }

        private fun draw(moveCount: Int) {
            for (i in 0 until moveCount) {
                print("-")
            }
            println()
        }
    }
}
