package dep.persistence.api

import dep.persistence.entities.User
import dep.persistence.repository.UserRepository
import dep.persistence.transfer.UserDto
import org.springframework.beans.factory.annotation.Autowired
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class UserAPIResource(@Autowired val userRepository: UserRepository) {

    @GET
    fun list() : List<User> {
        return userRepository.findAll()
    }

    @POST
    fun persist(userDto: UserDto) : User {
        val user = User(userDto.firstName, userDto.lastName, userDto.email)
        userRepository.save(user)
        return user
    }
}