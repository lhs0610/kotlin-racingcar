package racingcar.model

import kotlin.collections.MutableMap.MutableEntry

data class RaceHistory(val stepHistories: List<StepHistory>) {
    fun getWinnerGroupEntry(): MutableEntry<Int, List<String>> {
        val lastStepHistory = stepHistories.last()
        val reverseSortedGroup = lastStepHistory.stepRacingCarInfos.groupBy(
            { it.distance }, { it.racerName }
        ).toSortedMap(compareBy<Int> { it }.reversed())

        return reverseSortedGroup.entries.first()
    }
}
