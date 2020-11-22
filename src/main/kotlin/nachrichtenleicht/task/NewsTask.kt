package nachrichtenleicht.task

import nachrichtenleicht.NewsType
import nachrichtenleicht.service.NewsService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
class NewsTask {
    private val logger: Logger = LoggerFactory.getLogger(NewsTask::class.java)

    @Autowired
    lateinit var newsService: NewsService

    @Scheduled(cron = "0 0 14 * * FRI", zone = "UTC")
    fun saveTopNews() {
        logger.info("Start to fetch news, now={}", ZonedDateTime.now())

        NewsType.values()
                .forEach { newsType ->
                    try {
                        newsService.fetchAndSaveNews(newsType)
                    } catch (e: Exception) {
                        logger.error("Fetch news failed, newsType={}", newsType, e)
                    }
                }
    }
}