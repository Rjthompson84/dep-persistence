package dep.persistence.api

import dep.persistence.entities.Event
import dep.persistence.repository.EventRepository
import dep.persistence.transfer.EventDto
import org.eclipse.microprofile.openapi.annotations.Operation
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/events")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class EventAPIResource {

    @Inject
    lateinit var eventRepository: EventRepository

    /**
     * List all events owned by the user identified by ownerId param.
     */
    @GET
    @Path("/{ownerId}/")
    @Operation(summary = "List all events created by a user given their id.")
    fun listByOrganiser(@PathParam("ownerId") ownerId: Long) : List<Event> {
        return eventRepository.findByOwnerId(ownerId)
    }

    /**
     * Create an event object. Returns the created object in JSON format.
     */
    @POST
    @Operation(summary = "Create an Event!")
    fun create(eventDto: EventDto) : Event {
        val event = Event(eventDto.organiser!!, eventDto.title)
        event.timeAndDate = eventDto.dateAndTime
        event.venue = eventDto.venue
        return eventRepository.save(event)
    }
}