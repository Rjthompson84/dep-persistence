package dep.persistence.entities

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class Event(@ManyToOne val owner: User? = null,
                 val title: String = "",
                 var venue: String = "",
                 @OneToMany var guests: List<User> = ArrayList(),
                 @Column(name = "time_and_date") var timeAndDate: LocalDateTime? = null,
                 @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id : Long? = null
)