package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.service.Race

class RaceTest : BehaviorSpec({
    Given("자동차 리스트, 횟수 그리고 이동 정책(랜덤)이 제공된다.") {
        val racingCars = RacingCars(carNames = listOf("A", "B", "C"), RandomMovePolicy)
        val stepNum = 10
        When("레이스 경주를 할 때") {
            val race = Race()
            val raceResult = race.start(racingCars, stepNum)

            Then("최종 우승자가 일치한지 확인한다.") {
                raceResult.winners shouldBe racingCars.winners.map { it.name }
            }
        }
    }
})