import entity.Person
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

private const val NAME: String = "정종욱"
private const val NICK_NAME: String = "종구"

class PersonTest : DescribeSpec({

    describe("Person") {
        context("named parameter 로 객체를 생성하면") {
            val person = Person(name = NAME, age = 31, nickname = NICK_NAME)
            it("이름이 일치하는지 확인한다") {
                person.name shouldBe NAME
            }
        }
        context("Nickname이 null인 객체를 생성하면") {
            val person = Person(name = NAME, age = 31, null)
            it("널 타입일 수 있는 인자에 대해 테스트한다") {
                person.nickname.shouldBeNull()
            }
        }
        context("data class 객체를 생성하면") {
            val person1 = Person(name = NAME, age = 31, null)
            val person2 = Person(name = NAME, age = 31, null)
            val copyPerson1 = person1.copy()
            it("data class 로 생성하여 정상동작을 확인한다") {
                person1 shouldBe person2
                person1 shouldBe copyPerson1
            }
        }
    }
})
