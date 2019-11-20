package dep.persistence.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
        @Column(name = "first_name") val firstName : String = "",
        @Column(name = "last_name") val lastName : String = "",
        val email : String = "",
        var enabled : Boolean = false,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id : Long? = null
)