package dep.persistence.entities

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class EventTest {

    @Test
    fun testFields()
    {
        val user = User("test", "test", "email", id = 1L)
        val date = LocalDateTime.now()
        val event = Event(id = 1L, owner = user, title = "title", timeAndDate = date)
        event.venue = "venue"
        assertEquals(event.owner, user)
        assertEquals(event.id, 1L)
        assertEquals(event.title, "title")
        assertEquals(event.venue, "venue")
        assertEquals(event.timeAndDate, date)
    }
}