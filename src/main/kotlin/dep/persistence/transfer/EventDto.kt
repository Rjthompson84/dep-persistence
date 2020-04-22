package dep.persistence.transfer

import dep.persistence.entities.User
import java.time.LocalDateTime

/**
 * Data Transfer Object for an {@link dep.persistence.entities.Event}.
 * Provides a simple format for applications using the API to pass back relevant information to the persistence layer
 * of the API.
 *
 * All fields are set with default values of empty or null for serialization purposes.
 * Furthermore, the purpose of this API is to allow decisions to be made over time and therefore it is appropriate
 * to allow certain fields to accommodate the needs of the user.
 *
 * E.g. A user may not yet know the venue or date and time of the event at the time of event conception.
 */
class EventDto(
    /** The title of the event. Provides context and purpose for the user. */
    var title: String = "",

    /** The event organiser. */
    var organiser: User? = null,

    /** The event venue. @TODO This should probably be an entity of it's own type. */
    var venue: String = "",

    /** The potential date and time for the event. */
    var dateAndTime: LocalDateTime? = null
)
