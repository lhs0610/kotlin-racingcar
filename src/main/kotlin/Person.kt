data class Person(val name: String, val age: Int?, val nickname: String?) {

    constructor(name: String) : this(name, null, null)
}