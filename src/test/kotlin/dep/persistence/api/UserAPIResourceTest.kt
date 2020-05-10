package dep.persistence.api

import dep.persistence.entities.User
import dep.persistence.repository.UserRepository
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledIfSystemProperty
import javax.inject.Inject

@QuarkusTest
@DisabledIfSystemProperty(named = "profile", matches = "test")
internal class UserAPIResourceTest {

    private lateinit var user: User

    @Inject private lateinit var userRepo: UserRepository

    @Test
    fun testGet() {
        given()
                .`when`()
                .get("/users")
                .then()
                .statusCode(200)
    }

    @Test
    fun testPost()
    {
        given()
                .`when`()
                .header("Content-Type", "application/json")
                .body("""
                    { "firstName":"bobby", "lastName":"bobbins", "email":"email@email.com"}
                """.trimIndent().trim())
                .post("/users")
                .then()
                .statusCode(200)
    }

    @Test
    fun testPut()
    {
        user = userRepo.save(User("dave", "bob", "email"))
        given()
                .`when`()
                .header("Content-Type", "application/json")
                .body("""
                    { "firstName":"${user.firstName}", "lastName":"bobbins", "email":"${user.email}"}
                """.trimIndent().trim())
                .put("/users")
                .then()
                .statusCode(200)
    }

    @Test
    fun testDelete()
    {
        user = userRepo.save(User("dave", "bob", "email"))
        given()
                .`when`()
                .header("Content-Type", "application/json")
                .body("""
                    { "firstName":"${user.firstName}", "lastName":"${user.lastName}", "email":"${user.email}"}
                """.trimIndent().trim())
                .delete("/users")
                .then()
                .statusCode(200)
    }

}