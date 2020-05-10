package dep.persistence.api

import dep.persistence.entities.User
import dep.persistence.repository.UserRepository
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.Header
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledIfSystemProperty
import java.time.LocalDateTime
import javax.inject.Inject

@QuarkusTest
@DisabledIfSystemProperty(named = "profile", matches = "test")
internal class EventAPIResourceTest {

    @Inject private lateinit var userRepo: UserRepository

    @Test
    fun testGet() {
        given()
                .`when`()
                .get("/events/1/")
                .then()
                .statusCode(200)
    }

    @Test
    fun testPost() {
        var user : User = userRepo.save(User("dave", "bob", "email"))
        val requestBodyString =
                """
                    { 
                        "dateAndTime": "${LocalDateTime.now()}",
                        "organiser" : { 
                            "id":${user.id},
                            "firstName":"${user.firstName}", 
                            "lastName":"${user.lastName}", 
                            "email":"${user.email}",
                            "enabled":false
                        },
                        "title":"event",
                        "venue":"venue"
                    }
                    """.trimIndent()

        given()
                .`when`()
                .header(Header("Content-Type", "application/json"))
                .body(requestBodyString)
                .post("/events/")
                .then()
                .statusCode(200)
    }
}