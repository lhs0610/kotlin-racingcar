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
            val sb = StringBuilder()
            repeat(it) { sb.append(FOOTPRINTS_SYMBOL) }
            sb.toString()
        }.toList()

        for (footPrint in footPrints) { println(footPrint) }
    }
}
