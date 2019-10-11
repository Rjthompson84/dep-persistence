package dep.persistence.api

import dep.persistence.entities.User
import dep.persistence.store.UserRepo
import dep.persistence.transfer.UserDto
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter
import org.springframework.beans.factory.annotation.Autowired
import java.util.stream.Collectors
import javax.json.bind.Jsonb
import javax.json.bind.JsonbBuilder
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
class UserAPIResource(@Autowired val userRepo :UserRepo) {
    @GET
    @Path("/list")
    fun list() : List<User> {
        return userRepo.findAll()
    }

    @POST
    @Path("/create")
    fun persist(@Parameter(name = "userJson") userJson : String) : User? {
        val mapOfKeyValuPairs = HashMap<String, String>()
        val userDto = UserDto()

        val fields = userJson.split(",")
        for (string :String in fields) {
            val removedShit = string.replace("{", "")
            val removedShit2 = removedShit.replace("}", "")
            val leftRightPair = removedShit2.split(":")
            mapOfKeyValuPairs[leftRightPair[0].replace("\"", "")] = leftRightPair[1].replace("\"", "")
        }

        userDto.email = mapOfKeyValuPairs["email"]
        userDto.firstName = mapOfKeyValuPairs["firstName"]
        userDto.lastName = mapOfKeyValuPairs["lastName"]

        val user : User? = userDto.firstName?.let {
            userDto.lastName?.let {
                it1 -> userDto.email?.let {
                    it2 -> User(it, it1, it2)
                }
            }
        }
        userRepo.save(user)
        return user
    }
}