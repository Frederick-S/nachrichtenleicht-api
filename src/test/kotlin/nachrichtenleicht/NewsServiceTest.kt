package nachrichtenleicht

import nachrichtenleicht.service.NewsService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class NewsServiceTest : BaseTest() {
    @Autowired
    lateinit var newsService: NewsService

    @Test
    fun shouldFetchNews() {
        val news = newsService.fetchNews(Constant.NACHRICHTEN_RSS_URL)

        Assertions.assertTrue(news.isNotEmpty())
    }
}