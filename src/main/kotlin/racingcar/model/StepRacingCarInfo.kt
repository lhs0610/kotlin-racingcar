package racingcar.model

import racingcar.domain.RacingCar

data class StepRacingCarInfo (val racerName: String, val distance: Int) {
    companion object {
        fun from(racingcar: RacingCar): StepRacingCarInfo {
            return StepRacingCarInfo(racingcar.racerName, racingcar.getDistance())
        }
    }
}
