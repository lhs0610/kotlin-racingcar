package racingcar.domain

import racingcar.model.RacingCarSetting
import racingcar.model.StepRacingCarInfo
import racingcar.strategy.RaceStrategy

class RacingCarContainer private constructor(
    private val racingCars: List<RacingCar>
) {
    fun stepProgress(raceStrategy: RaceStrategy): List<StepRacingCarInfo> {
        racingCars.forEach { it.attemptMove(raceStrategy) }

        return racingCars.map { StepRacingCarInfo.from(it) }
    }

    companion object {
        fun from(settings: List<RacingCarSetting>): RacingCarContainer {
            val racingCars = settings.map { RacingCar.of(it.racerName, it.initPosition) }.toList()
            return RacingCarContainer(racingCars)
        }
    }
}
