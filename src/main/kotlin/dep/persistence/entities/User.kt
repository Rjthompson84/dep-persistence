package dep.persistence.entities

import javax.persistence.*

@Entity
class User(@Column(name = "first_name") val firstName : String,
           @Column(name = "last_name") val lastName : String,
           val email : String) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id : Long? = null
    val enabled : Boolean = false
}