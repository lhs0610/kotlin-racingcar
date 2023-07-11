package racingcar.service

import racingcar.contants.ErrorType
import racingcar.domain.RacingCars
import racingcar.domain.RandomMovePolicy
import racingcar.model.RaceResultDto
import racingcar.model.StepResultDto

class Race(
    racingCarNum: Int,
    private val stepNum: Int
) {
    private val racingCars: RacingCars

    init {
        require(stepNum > 0)  {
            ErrorType.INVALID_NUMBER.message
        }

        racingCars = RacingCars(racingCarNum = racingCarNum, movePolicy = RandomMovePolicy())
    }

    fun start(): RaceResultDto {
        val stepResultList = (1..stepNum)
            .asSequence()
            .map {
                racingCars.step()
                StepResultDto(racingCars.movedDistanceList)
            }.toList()

        return RaceResultDto(stepResultList)
    }
}