package nachrichtenleicht.service

import com.apptastic.rssreader.RssReader
import nachrichtenleicht.NewsType
import nachrichtenleicht.entity.News
import nachrichtenleicht.entity.NewsWord
import nachrichtenleicht.repository.NewsRepository
import nachrichtenleicht.repository.NewsWordRepository
import nachrichtenleicht.repository.WordRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.streams.toList

@Service
class NewsService {
    @Autowired
    private lateinit var newsParser: NewsParser

    @Autowired
    private lateinit var newsRepository: NewsRepository

    @Autowired
    private lateinit var wordRepository: WordRepository

    @Autowired
    private lateinit var newsWordRepository: NewsWordRepository

    fun fetchNews(newsType: NewsType): List<News> {
        val rssReader = RssReader()
        val items = rssReader.read(newsType.feedUrl)

        return items.map { item -> newsParser.parse(item) }
            .peek { news -> news.type = newsType.type }
            .toList()
    }

    @Transactional
    fun fetchAndSaveNews(newsType: NewsType) {
        val newsList = fetchNews(newsType)

        if (newsList.isEmpty()) {
            return
        }

        newsRepository.saveAll(newsList)

        val words = newsList.flatMap { news ->
            news.words
        }.distinctBy { word ->
            word.name
        }.map { word ->
            val currentWords = wordRepository.findByName(word.name)

            if (currentWords.isEmpty()) {
                word
            } else {
                val currentWord = currentWords.first()
                currentWord.definition = word.definition

                currentWord
            }
        }

        wordRepository.saveAll(words)

        val wordNameIdMap = words.associateBy({ it.name }, { it.id })
        val newsWords = newsList.flatMap { news ->
            news.words
                .map { word ->
                    val newsWord = NewsWord()
                    newsWord.newsId = news.id
                    newsWord.wordId = wordNameIdMap.getOrDefault(word.name, 0)

                    newsWord
                }
        }

        newsWordRepository.saveAll(newsWords)
    }
}
