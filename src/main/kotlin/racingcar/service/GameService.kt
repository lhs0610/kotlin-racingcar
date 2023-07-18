package racingcar.service

import racingcar.component.Race
import racingcar.model.dto.RaceHistoryDto
import racingcar.strategy.RaceStrategy

object GameService {

    fun startRacingGame(racingcarQuantity: Int, totalStep: Int, raceStrategy: RaceStrategy): RaceHistoryDto {
        val racingGame = Race(racingcarQuantity, totalStep, raceStrategy)
        return racingGame.start()
    }
}