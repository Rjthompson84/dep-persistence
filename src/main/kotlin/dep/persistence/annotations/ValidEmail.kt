package dep.persistence.annotations

import javax.validation.Constraint
import javax.validation.Payload
import javax.validation.constraints.Email
import javax.validation.constraints.Pattern
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [])
@Email
@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address.")
annotation class ValidEmail(
        val message: String = "Invalid",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = [])