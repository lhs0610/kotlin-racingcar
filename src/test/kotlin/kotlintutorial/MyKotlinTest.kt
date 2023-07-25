package kotlintutorial

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import tutorial.domain.person.Person

class MyKotlinTest : ExpectSpec({

    context("domain test: domain.Person.Person") {
        expect("named argument test") {
            val person = Person(name = "심의진", age = 22, nickname = "Jinni01")

            person.name shouldBe "심의진"
        }

        expect("nullable parameter test") {
            val person = Person.of("심의진", 22)

            person.nickname shouldBe null
        }

        expect("data class test") {
            val person = Person(name = "심의진", age = 22, nickname = "Jinni01")

            // use copy function from data class
            val other = person.copy(name = "신의진", nickname = "Jinni001")

            val shouldBeTypeOf = person.shouldBeTypeOf<Person>()
            // same reference
            shouldBeTypeOf.nickname = "Jinni02"

            println(person)
            println(other)

            person.age shouldBe other.age
        }
    }
})
