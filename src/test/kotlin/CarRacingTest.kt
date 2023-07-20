import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import racingcar.utils.RaceUtils
import racingcar.view.InputView

class CarRacingTest : DescribeSpec({

    describe("RacingCar") {
        context("0 에서 9 사이에서 무작위 숫자가 주어진다") {
            val randomNumber = RaceUtils.randomNumber().toInt()
            it("4 이상일 경우 움직인다") {
                randomNumber shouldBeInRange (1..9)
                RaceUtils.moveOrNot(4, randomNumber) shouldBe (4 <= randomNumber)
            }
        }

        context("자동차 수와 움직일 횟수를 입력한다") {
            val input = InputView()
            input.carInfo()
            it("정상입력되었는지 확인한다") {
                input.getCarCount()
                input.getTryCount()
            }
        }

    }
})
