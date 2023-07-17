package domain.racingcar.factory

import domain.racingcar.strategy.RaceStrategy
import domain.racingcar.RacingCar

object RacingCarFactory {
    fun generateRacingCars(quantity: Int, strategy: RaceStrategy): List<RacingCar> {

        val racingCars = mutableListOf<RacingCar>()
        for (i in 1..quantity) {
            racingCars.add(RacingCar(strategy))
        }
        return racingCars.toList()
    }
}