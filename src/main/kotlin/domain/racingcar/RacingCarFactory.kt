package domain.racingcar

object RacingCarFactory {
    fun generateRacingCars(quantity: Int, strategy: RaceStrategy): List<RacingCar> {

        val racingCars = mutableListOf<RacingCar>()
        for (i in 1..quantity) {
            racingCars.add(RacingCar(strategy))
        }
        return racingCars.toList()
    }
}