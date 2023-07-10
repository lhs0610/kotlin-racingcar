import entity.Person
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

private const val NAME: String = "정종욱"

/**
 * DescribeSpec DCI 패턴
 * Describe : 테스트 대상
 * Context : 조건, 상황
 * It : 결과
 **/
@DisplayName("Step 1")
class RacingTest : DescribeSpec({

    describe("Person") {
        context("객체를 생성하면") {
            val person = Person(NAME)
            it("이름이 일치하는지 확인한다") {
                person.name shouldBe NAME
            }

            it("널 타입일 수 있는 인자에 대해 테스트한다") {
                person.nickname.shouldBeNull()
            }

            it("data class 로 생성하여 정상동작을 확인한다") {
                person.name shouldBe NAME
            }
        }
    }
})