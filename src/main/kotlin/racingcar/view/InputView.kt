package racingcar.view

class InputView {
    private var carCount: Int = 0
    private var tryCount: Int = 0

    fun carInfo() {
        println("자동차 대수는 몇 대 인가요?")
        carCount = readLine()!!.toInt()
        println("시도할 회수는 몇 회 인가요?")
        tryCount = readLine()!!.toInt()
        println("")
    }

    fun getCarCount(): Int {
        return carCount
    }

    fun getTryCount(): Int {
        return tryCount
    }
}
