package racingcar.view

class ResultView {
    companion object {
        fun draw(moveCount: Int) {
            for (i in 0 until moveCount) {
                print("-")
            }
            println()
        }
    }
}
