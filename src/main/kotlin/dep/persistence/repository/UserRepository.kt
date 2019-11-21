package dep.persistence.repository

import dep.persistence.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import javax.inject.Singleton

@Singleton
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String) : User
}