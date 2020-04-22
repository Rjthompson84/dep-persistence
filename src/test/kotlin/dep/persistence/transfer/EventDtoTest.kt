package dep.persistence.transfer

import dep.persistence.entities.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class EventDtoTest {

    @Test
    fun testFields()
    {
        val eventDto = EventDto()
        val date = LocalDateTime.now()
        eventDto.dateAndTime = date
        val user = User(id = 1L, firstName = "test", lastName = "test", email = "email@email.email")
        eventDto.organiser = user
        eventDto.title = "title"
        eventDto.venue = "venue"
        assertEquals(eventDto.dateAndTime, date)
        assertEquals(eventDto.venue, "venue")
        assertEquals(eventDto.organiser, user)
        assertEquals(eventDto.title, "title")
    }
}