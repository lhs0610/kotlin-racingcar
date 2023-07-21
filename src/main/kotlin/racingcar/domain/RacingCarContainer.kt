package racingcar.domain

import racingcar.component.RacingCarFactory
import racingcar.model.RacingCarSetting
import racingcar.model.StepRacingCarInfo
import racingcar.strategy.RaceStrategy

class RacingCarContainer private constructor(
    settings: List<RacingCarSetting>
) {
    private val racingCars: List<RacingCar> = RacingCarFactory.generateRacingCars(settings)

    fun stepProgress(raceStrategy: RaceStrategy): List<StepRacingCarInfo> {
        racingCars.forEach() { it.attemptMove(raceStrategy) }

        return racingCars.map { StepRacingCarInfo.from(it) }
    }

    companion object {
        fun from(settings: List<RacingCarSetting>): RacingCarContainer {
            return RacingCarContainer(settings)
        }
    }
}

fun List<RacingCar>.getAllDistance(): List<Int> {
    return this.map { it.getDistance() }
}
