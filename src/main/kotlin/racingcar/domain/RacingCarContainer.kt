package racingcar.domain

import racingcar.component.RacingCarFactory
import racingcar.model.vo.RacingCarSettingVO
import racingcar.strategy.RaceStrategy

class RacingCarContainer private constructor(
    settings: List<RacingCarSettingVO>
) {
    private val racingCars: List<RacingCar> = RacingCarFactory.generateRacingCars(settings)

    fun stepProgress(raceStrategy: RaceStrategy): List<Int> {
        racingCars.forEach() { it.attemptMove(raceStrategy) }
        return racingCars.getAllDistance()
    }

    companion object {
        fun from(settings: List<RacingCarSettingVO>): RacingCarContainer {
            return RacingCarContainer(settings)
        }
    }
}

fun List<RacingCar>.getAllDistance(): List<Int> {
    return this.map { it.getDistance() }
}
