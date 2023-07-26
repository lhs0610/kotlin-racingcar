package racingcar.view

import racingcar.model.RaceHistory
import racingcar.model.StepHistory
import kotlin.collections.MutableMap.MutableEntry

object ResultView {

    private const val FOOTPRINTS_SYMBOL = "-"

    fun printRacingGameResult(raceHistory: RaceHistory) {

        raceHistory.stepHistories.forEach {
            printStepHistory(it)
            println()
        }

        printWinners(raceHistory.getWinnerGroupEntry())
    }

    private fun printStepHistory(stepHistory: StepHistory) {

        val footPrints = stepHistory.stepRacingCarInfos.map { it.distance }.map {
            FOOTPRINTS_SYMBOL.repeat(it)
        }

        footPrints.forEach { println(it) }
    }

    private fun printWinners(winnerGroupEntry: MutableEntry<Int, List<String>>) {
        println("${winnerGroupEntry.value}(${winnerGroupEntry.key}) 가 최종 우승했습니다.")
    }
}
