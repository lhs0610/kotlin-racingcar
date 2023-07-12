import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.types.shouldBeTypeOf

class Step1 : StringSpec({
    "named arguments" {
        val p = Person("name", 20, "nickname")
        p.shouldBeTypeOf<Person>()
    }

    "nullable types" {
        val p = Person(null, 0, null)
        p.shouldBeTypeOf<Person>()
    }

    "data class" {
        val p = Person("name", 30, null)
        println(p)
        p.shouldBeTypeOf<Person>()
    }
})
