package nachrichtenleicht.service

import com.apptastic.rssreader.Item
import nachrichtenleicht.entity.News
import org.jsoup.Jsoup
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class NewsParser {
    fun parse(item: Item): News {
        val url = item.link.orElse("")
        val document = Jsoup.connect(url).get()
        val news = News()
        news.title = item.title.orElse("")
        news.description = document.select(".dra-lsp-artikel-haupttex-kurztext").text()
        news.url = url
        news.imageUrl = document.select(".dra-lsp-artikel-haupttext-bild").attr("src")
        news.body = document.select(".dra-lsp-artikel-haupttext-absatz p")
                .joinToString("\n") { element -> element.text() }
        news.publishedAtUtc = item.pubDateZonedDateTime
                .map { date -> date.toInstant() }
                .orElse(Instant.MIN)

        return news
    }
}