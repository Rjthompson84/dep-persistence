package dep.persistence.transfer

import dep.persistence.annotations.ValidEmail

class UserDto {
    var firstName : String = ""
    var lastName : String = ""
    @ValidEmail var email : String = ""
}