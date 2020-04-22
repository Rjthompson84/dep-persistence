package dep.persistence.api

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledIfSystemProperty

@QuarkusTest
@DisabledIfSystemProperty(named = "profile", matches = "test")
internal class EventAPIResourceTest {

    @Test
    fun testGet() {
        given()
                .`when`()
                .get("/events/1/")
                .then()
                .statusCode(200)
    }
}