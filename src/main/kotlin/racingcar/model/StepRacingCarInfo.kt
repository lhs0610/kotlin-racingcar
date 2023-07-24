package racingcar.model

import racingcar.domain.RacingCar

data class StepRacingCarInfo(val racerName: String, val distance: Int) {
    companion object {
        fun from(racingCar: RacingCar): StepRacingCarInfo {
            return StepRacingCarInfo(racingCar.getRacerName(), racingCar.getDistance())
        }
    }
}
