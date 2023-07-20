package racingcar.service

import racingcar.domain.RacingCarContainer
import racingcar.model.dto.RaceHistoryDto
import racingcar.model.dto.StepHistoryDto
import racingcar.model.vo.RacingCarSettingVO
import racingcar.strategy.RaceStrategy

object RaceGameService {

    private const val START_DISTANCE = 0

    fun startRacingGame(racingcarQuantity: Int, totalStep: Int, raceStrategy: RaceStrategy): RaceHistoryDto {
        val racingCarContainer = RacingCarContainer.from(List(racingcarQuantity) { RacingCarSettingVO(START_DISTANCE) })

        return (0 until totalStep).map {
            val stepResult = racingCarContainer.stepProgress(raceStrategy)
            StepHistoryDto(stepResult)
        }.let(::RaceHistoryDto)
    }
}
