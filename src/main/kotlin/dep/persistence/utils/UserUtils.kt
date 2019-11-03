package dep.persistence.utils

import dep.persistence.entities.User
import dep.persistence.transfer.UserDto

class UserUtils {
    companion object {
        @JvmStatic fun update(newUserDetails: UserDto, userToUpdate: User) : User {
            return userToUpdate.copy(firstName = newUserDetails.firstName,
                             lastName = newUserDetails.lastName,
                             email = newUserDetails.email, id = userToUpdate.id, enabled = userToUpdate.enabled)
        }
    }
}