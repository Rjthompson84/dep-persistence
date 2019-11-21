package dep.persistence

import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test

@DepIntegrationTest
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