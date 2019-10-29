package dep.persistence

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test

@QuarkusTest
class UserAPIResourceTest {

    @Test
    fun testGet() {
        given()
            .`when`()
                .get("/users")
            .then()
            .statusCode(200)
    }
}