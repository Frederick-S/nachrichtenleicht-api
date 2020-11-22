package nachrichtenleicht.repository

import nachrichtenleicht.entity.NewsWord
import org.springframework.data.jpa.repository.JpaRepository

interface NewsWordRepository : JpaRepository<NewsWord, Int> {
}