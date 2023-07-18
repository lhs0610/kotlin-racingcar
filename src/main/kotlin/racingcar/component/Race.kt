package racingcar.component

import racingcar.domain.RacingCarContainer
import racingcar.domain.RacingCarPosition
import racingcar.dto.RaceHistoryDto
import racingcar.dto.StepHistoryDto
import racingcar.strategy.RaceStrategy

class Race(
    private val racingcarQuantity: Int,
    private val totalStep: Int,
    private val raceStrategy: RaceStrategy
) {

    fun start(): RaceHistoryDto {
        val racingCarContainer = RacingCarContainer(racingcarQuantity, RacingCarPosition(START_DISTANCE))

        return (0 until totalStep).map {
            val stepResult = racingCarContainer.stepProgress(raceStrategy)
            StepHistoryDto(stepResult)
        }.let(::RaceHistoryDto)
    }

    companion object {
        private const val START_DISTANCE = 0
    }
}