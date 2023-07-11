package racingcar.service

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
        racingCars = RacingCars(racingCarNum = racingCarNum, movePolicy = RandomMovePolicy())
    }

    fun start(): RaceResultDto {
        val stepResultList = mutableListOf<StepResultDto>()
        for (i in 0 until stepNum) {
            racingCars.step()
            val stepResult = StepResultDto(racingCars.movedDistanceList)
            stepResultList.add(stepResult)
        }
        return RaceResultDto(stepResultList)
    }
}