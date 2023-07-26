import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

class Step1 : StringSpec({
    "named arguments" {
        val person = Person(name = "name", nickname = "nickname", age = 20)
        person.age shouldBe 20
    }

    "nullable types" {
        val person = Person("myName", 0, null)
        person.shouldBeTypeOf<Person>()
    }

    "data class" {
        val person1 = Person("name", 30, null)
        val person2 = Person("name", 30, null)

        person1 shouldBe person2
    }
})
