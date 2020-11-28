package nachrichtenleicht.entity

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class News : BaseEntity() {
    @Column(length = 50)
    var title = ""

    @Column(length = 1000)
    var description = ""

    @Column(length = 200)
    var url = ""

    @Column(length = 200)
    var imageUrl = ""

    @Column(columnDefinition = "text")
    var body = ""

    @Column(length = 200)
    var audioUrl = ""

    var publishedAtUtc = Instant.now()

    var type = 0

    @Transient
    var words = mutableSetOf<Word>()
}