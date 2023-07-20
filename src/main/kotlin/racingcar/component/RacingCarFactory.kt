package racingcar.component

import racingcar.domain.RacingCar
import racingcar.domain.RacingCarPosition
import racingcar.model.vo.RacingCarSettingVO

object RacingCarFactory {
    fun generateRacingCars(settings: List<RacingCarSettingVO>): List<RacingCar> {
        return settings.map { RacingCar(RacingCarPosition(it.initPosition)) }.toList()
    }
}
