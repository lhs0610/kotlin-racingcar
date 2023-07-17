package domain.Person

data class Person(val name: String, val age: Int, var nickname: String?) {

    companion object {
        fun of(name: String, age: Int): Person {
            return Person(name, age, null)
        }
    }
}