package nachrichtenleicht.dto

import java.time.Instant

class NewsDto {
    var title = ""

    var description = ""

    var url = ""

    var imageUrl = ""

    var body = ""

    var audioUrl = ""

    var publishedAtUtc = Instant.now()

    var type = 0
}