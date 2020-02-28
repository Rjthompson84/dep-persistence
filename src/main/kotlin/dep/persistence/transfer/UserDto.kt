package dep.persistence.transfer

import dep.persistence.annotations.ValidEmail

/**
 * Data Transfer Object for incoming new user details from which
 * new dep.persistence.entities.User entities can be created.
 *
 * Allows for persistence-specific information to remain anonymous during transfer.
 */
class UserDto {
    var firstName : String = ""
    var lastName : String = ""
    @ValidEmail var email : String = ""
}