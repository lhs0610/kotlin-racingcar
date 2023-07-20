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

        val footPrints = stepHistory.positions.map {
            FOOTPRINTS_SYMBOL.repeat(it)
        }.toList()

        for (footPrint in footPrints) { println(footPrint) }
    }
}
