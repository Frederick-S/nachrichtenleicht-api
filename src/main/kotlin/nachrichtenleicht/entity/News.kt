package nachrichtenleicht.entity

import javax.persistence.Column
import javax.persistence.Entity

@Entity
class News : BaseEntity() {
    @Column(length = 50)
    var title = ""
}