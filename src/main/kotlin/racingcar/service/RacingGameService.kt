package racingcar.service

import racingcar.domain.RacingCarContainer
import racingcar.model.RaceHistory
import racingcar.model.RaceSetting
import racingcar.model.StepHistory
import racingcar.strategy.RaceStrategy

object RacingGameService {

    fun startRacingGame(raceSetting: RaceSetting, raceStrategy: RaceStrategy): RaceHistory {
        val racingCarContainer = RacingCarContainer.from(raceSetting.racingCarSettings)

        return (0 until raceSetting.totalStep).map {
            val stepResult = racingCarContainer.stepProgress(raceStrategy)
            StepHistory(stepResult)
        }.let(::RaceHistory)
    }
}
