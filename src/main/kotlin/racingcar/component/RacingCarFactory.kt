package racingcar.component

import racingcar.strategy.RaceStrategy
import racingcar.domain.RacingCar

object RacingCarFactory {
    fun generateRacingCars(quantity: Int, strategy: RaceStrategy): List<RacingCar> {

        val racingCars = mutableListOf<RacingCar>()
        for (i in 1..quantity) {
            racingCars.add(RacingCar(strategy))
        }
        return racingCars.toList()
    }
}