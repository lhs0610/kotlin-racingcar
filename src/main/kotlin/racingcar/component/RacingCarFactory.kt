package racingcar.component

import racingcar.domain.RacingCar
import racingcar.domain.RacingCarPosition
import racingcar.model.RacingCarSetting

object RacingCarFactory {
    fun generateRacingCars(settings: List<RacingCarSetting>): List<RacingCar> {
        return settings.map { RacingCar(it.racerName, RacingCarPosition(it.initPosition)) }.toList()
    }
}
