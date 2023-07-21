package racingcar.view

import racingcar.model.RaceHistory
import racingcar.model.StepHistory

object ResultView {

    private const val FOOTPRINTS_SYMBOL = "-"

    fun printRacingGameResult(raceHistory: RaceHistory) {

        raceHistory.stepHistories.forEach() {
            printStepHistory(it)
            println()
        }

        val lastStepHistory = raceHistory.stepHistories.last()
        printWinners(lastStepHistory)
    }

    private fun printStepHistory(stepHistory: StepHistory) {

        val footPrints = stepHistory.stepRacingCarInfos.map { it.distance }.map {
            FOOTPRINTS_SYMBOL.repeat(it)
        }

        footPrints.forEach { println(it) }
    }

    private fun printWinners(lastStepHistory: StepHistory) {
        val reverseSortedGroups = lastStepHistory.stepRacingCarInfos.groupBy(
            { it.distance }, { it.racerName }
        ).toSortedMap(compareBy<Int> { it }.reversed())

        val winnerGroup = reverseSortedGroups.entries.first()
        println("${winnerGroup.value}(${winnerGroup.key}) 가 최종 우승했습니다.")
    }
}
