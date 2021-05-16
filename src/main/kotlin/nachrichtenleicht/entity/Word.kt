package nachrichtenleicht.entity

import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Word : BaseEntity() {
    @Column(length = 50)
    var name = ""

    @Column(length = 1000)
    var definition = ""
}
