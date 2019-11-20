package dep.persistence.api

import dep.persistence.entities.User
import dep.persistence.repository.UserRepository
import dep.persistence.transfer.UserDto
import dep.persistence.utils.UserUtils
import org.eclipse.microprofile.openapi.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class UserAPIResource(@Autowired val userRepository: UserRepository) {

    @GET
    @Operation(summary = "List all users.", description = "Should only be used by administrative users.")
    fun list() : List<User> {
        return userRepository.findAll()
    }

    @POST
    @Operation(summary = "Create a new user.")
    fun create(userDto: UserDto) : User {
        val user = User(userDto.firstName, userDto.lastName, userDto.email)
        return userRepository.save(user)
    }

    @PUT
    @Operation(summary = "Update an existing user.")
    fun update(user: UserDto) : User {
        val userByEmail = userRepository.findByEmail(user.email)
        val utilsUpdated = UserUtils.update(user, userByEmail)
        return userRepository.save(utilsUpdated)
    }

    @DELETE
    @Operation(summary = "Delete an existing user.")
    fun delete(user: UserDto) : String {
        val userToDelete = userRepository.findByEmail(user.email)
        userRepository.deleteById(userToDelete.id!!)
        return "Successfully deleted user with id: ${userToDelete.id}"
    }
}