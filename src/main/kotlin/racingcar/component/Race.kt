package racingcar.component

import racingcar.domain.RacingCarContainer
import racingcar.dto.RaceHistoryDto
import racingcar.dto.StepHistoryDto
import racingcar.strategy.RaceStrategy

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