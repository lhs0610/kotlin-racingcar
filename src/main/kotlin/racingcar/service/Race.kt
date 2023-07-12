package racingcar.service

import racingcar.contants.ErrorType
import racingcar.domain.RacingCars
import racingcar.model.RaceResultDto
import racingcar.model.StepResultDto

class Race(
    private val racingCars: RacingCars
) {
    fun start(stepNum: Int): RaceResultDto {
        require(stepNum > 0)  {
            ErrorType.INVALID_NUMBER.message
        }

        val stepResultList = List(stepNum) {
            racingCars.step()
            StepResultDto(racingCars.movedDistanceList)
        }

        return RaceResultDto(stepResultList)
    }
}