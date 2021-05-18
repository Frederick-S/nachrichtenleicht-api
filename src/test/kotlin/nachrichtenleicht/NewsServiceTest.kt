package nachrichtenleicht

import nachrichtenleicht.repository.NewsRepository
import nachrichtenleicht.service.NewsService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class NewsServiceTest : BaseTest() {
    @Autowired
    private lateinit var newsService: NewsService

    @Autowired
    private lateinit var newsRepository: NewsRepository

    @Test
    fun shouldFetchNews() {
        val news = newsService.fetchNews(NewsType.NACHRICHTEN)

        Assertions.assertTrue(news.isNotEmpty())
    }

    @Test
    fun shouldSaveNews() {
        newsService.fetchAndSaveNews(NewsType.NACHRICHTEN)

        val news = newsRepository.findAll()

        Assertions.assertTrue(news.isNotEmpty())
    }
}
