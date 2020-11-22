package nachrichtenleicht.service

import com.apptastic.rssreader.RssReader
import nachrichtenleicht.NewsType
import nachrichtenleicht.entity.News
import nachrichtenleicht.repository.NewsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.streams.toList

@Service
class NewsService {
    @Autowired
    lateinit var newsParser: NewsParser

    @Autowired
    lateinit var newsRepository: NewsRepository

    fun fetchNews(newsType: NewsType): List<News> {
        val rssReader = RssReader()
        val items = rssReader.read(newsType.feedUrl)

        return items.map { item -> newsParser.parse(item) }
                .peek { news -> news.type = newsType.type }
                .toList()
    }

    @Transactional
    fun fetchAndSaveNews(newsType: NewsType) {
        val news = fetchNews(newsType)

        if (news.isEmpty()) {
            return
        }

        newsRepository.saveAll(news)
    }
}