package nachrichtenleicht.controller.api

import nachrichtenleicht.controller.BaseController
import nachrichtenleicht.dto.NewsDto
import nachrichtenleicht.repository.NewsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Date

@RestController
class NewsController : BaseController() {
    @Autowired
    lateinit var newsRepository: NewsRepository

    @GetMapping("/news")
    fun getNews(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) startDate: Date,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) endDate: Date,
            @RequestParam type: Int): List<NewsDto> {
        return newsRepository.findByPublishedAtUtcBetweenAndType(startDate.toInstant(), endDate.toInstant(), type)
                .map { news ->
                    val dto = NewsDto()
                    dto.id = news.id
                    dto.title = news.title
                    dto.description = news.description
                    dto.url = news.url
                    dto.imageUrl = news.imageUrl
                    dto.body = news.body
                    dto.publishedAtUtc = news.publishedAtUtc
                    dto.type = news.type
                    dto.audioUrl = news.audioUrl

                    dto
                }
    }
}