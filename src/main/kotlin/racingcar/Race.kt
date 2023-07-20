package racingcar

import racingcar.utils.RaceUtils
import racingcar.view.ResultView

private const val MOVE_COUNT_CONDITION = 4

class Race {

    private val racingCarList: MutableList<RacingCar> = ArrayList()

    fun ready(racingCarCount: Int) {
        for (i in 0 until racingCarCount) {
            racingCarList.add(RacingCar())
        }
    }

    fun startAndDraw(tryCount: Int) {
        println("")
        for (i in 0 until tryCount) {
            race()
        }
    }

    private fun race() {
        for (racingCar in racingCarList) {
            val randomNumber = RaceUtils.randomNumber()
            if (RaceUtils.moveOrNot(MOVE_COUNT_CONDITION, randomNumber)) {
                racingCar.move()
            }
            ResultView.draw(racingCar.moveCount)
        }
        println()
    }
}
