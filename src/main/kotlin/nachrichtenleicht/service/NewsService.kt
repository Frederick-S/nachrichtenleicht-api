package nachrichtenleicht.service

import com.apptastic.rssreader.RssReader
import nachrichtenleicht.entity.News
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class NewsService {
    @Autowired
    lateinit var newsParser: NewsParser

    fun fetchNews(url: String): List<News> {
        val rssReader = RssReader()
        val items = rssReader.read(url)

        return items.map { item -> newsParser.parse(item) }.toList()
    }
}