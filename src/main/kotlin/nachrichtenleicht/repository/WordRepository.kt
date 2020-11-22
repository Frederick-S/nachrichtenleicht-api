package nachrichtenleicht.repository

import nachrichtenleicht.entity.Word
import org.springframework.data.jpa.repository.JpaRepository

interface WordRepository : JpaRepository<Word, Int> {
    fun findByName(name: String): List<Word>
}