package nachrichtenleicht.controller.api

import nachrichtenleicht.controller.BaseController
import nachrichtenleicht.dto.WordDto
import nachrichtenleicht.repository.NewsWordRepository
import nachrichtenleicht.repository.WordRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WordController : BaseController() {
    @Autowired
    private lateinit var newsWordRepository: NewsWordRepository

    @Autowired
    private lateinit var wordRepository: WordRepository

    @GetMapping("/words")
    fun getWords(@RequestParam newsId: Int): List<WordDto> {
        val newsWords = newsWordRepository.findByNewsId(newsId)

        if (newsWords.isEmpty()) {
            return emptyList()
        }

        val wordIds = newsWords.map { newsWord -> newsWord.wordId }
        val words = wordRepository.findByIdIn(wordIds)

        return words.map { word ->
            val wordDto = WordDto()
            wordDto.id = word.id
            wordDto.name = word.name
            wordDto.definition = word.definition

            wordDto
        }
    }
}
