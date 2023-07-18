package racingcar.view

import racingcar.model.dto.RaceHistoryDto
import racingcar.model.dto.StepHistoryDto

object ResultView {

    private const val FOOTPRINTS_SYMBOL = "-"

    fun printRacingGameResult(raceHistory: RaceHistoryDto) {

        raceHistory.stepHistories.forEach() {
            printStepHistory(it)
            println()
        }
    }

    private fun printStepHistory(stepHistory: StepHistoryDto) {

        stepHistory.positions.forEach() {
            for (i in 1..it) {
                print(FOOTPRINTS_SYMBOL)
            }
            println()
        }
    }
}