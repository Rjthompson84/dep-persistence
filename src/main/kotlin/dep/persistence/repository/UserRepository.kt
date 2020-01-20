package dep.persistence.repository

import dep.persistence.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String) : User
}