package dep.persistence.repository

import dep.persistence.entities.Event
import org.springframework.data.jpa.repository.JpaRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
interface EventRepository : JpaRepository<Event, Long> {
    fun findByOwnerId(ownerId: Long) : List<Event>
}