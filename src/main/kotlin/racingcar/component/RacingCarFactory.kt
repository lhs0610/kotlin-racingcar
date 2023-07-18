package racingcar.component

import racingcar.domain.RacingCar
import racingcar.domain.RacingCarPosition

object RacingCarFactory {
    fun generateRacingCars(quantity: Int, position: RacingCarPosition): List<RacingCar> {

        val racingCars = mutableListOf<RacingCar>()
        for (i in 1..quantity) { racingCars.add(RacingCar(position)) }
        return racingCars.toList()
    }
}