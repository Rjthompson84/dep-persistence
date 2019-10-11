package dep.persistence.endpoint

import dep.persistence.entities.User
import dep.persistence.store.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/register")
class UserReg(@Autowired val userRepo: UserRepo) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun show() : List<User> {
        return userRepo.findAll()
    }
}