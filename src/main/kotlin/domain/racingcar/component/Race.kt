package domain.racingcar.component

import domain.racingcar.RacingCarContainer
import domain.racingcar.dto.RaceHistoryDto
import domain.racingcar.dto.StepHistoryDto
import domain.racingcar.strategy.RaceStrategy
import domain.racingcar.strategy.RandomStrategy

class Race(
    private val racingcarQuantity: Int,
    private val totalStep: Int,
    private val raceStrategy: RaceStrategy
) {
    private val raceHistory = mutableListOf<StepHistoryDto>()

    fun start(): RaceHistoryDto {

        val racingCarContainer = RacingCarContainer(racingcarQuantity, raceStrategy)

        for (i in 1..totalStep) {
            val stepHistory = racingCarContainer.stepProgress()
            raceHistory.add(stepHistory)
        }

        return RaceHistoryDto(raceHistory)
    }
}