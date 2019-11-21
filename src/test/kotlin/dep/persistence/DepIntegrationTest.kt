package dep.persistence

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.condition.DisabledIfSystemProperty

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@QuarkusTest
@DisabledIfSystemProperty(named = "profile", matches = "test")
annotation class DepIntegrationTest {
}

//public @interface MyApplicationTest {
//}