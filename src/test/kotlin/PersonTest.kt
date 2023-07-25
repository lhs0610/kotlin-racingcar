import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

private const val NAME = "권구상"
private const val AGE = 27
private const val NICKNAME = "kks1023"

@DisplayName("Step 1 : 코틀린 기초")
class PersonTest : FunSpec({

    test("named arguments: 이름 붙인 인자를 이용해 객체를 생성해본다.") {
        val person = Person(name = NAME, age = AGE, nickname = NICKNAME)
        person.name shouldBe NAME
    }

    test("nullable types: 인자 중 널 타입일 수 있는 인자에 대해 테스트해본다.") {
        val person = Person(name = NAME)
        person.age.shouldBeNull()
        person.nickname.shouldBeNull()
    }

    test("data classes: Person을 데이터 클래스로 만들어보고 정상 동작하는지 확인해본다.") {
        val person = Person(NAME, AGE, NICKNAME)
        person.name.shouldBeNull()
        person.age.shouldBeNull()
        person.nickname.shouldBeNull()
    }
})
