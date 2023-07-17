package domain

class RacingCar(var position: Int = 0) {

    fun move(distance: Int) {
        position += distance;
    }
}