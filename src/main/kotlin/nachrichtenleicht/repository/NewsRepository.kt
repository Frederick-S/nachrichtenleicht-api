package nachrichtenleicht.repository

import nachrichtenleicht.entity.News
import org.springframework.data.jpa.repository.JpaRepository
import java.time.Instant

interface NewsRepository : JpaRepository<News, Int> {
    fun findByPublishedAtUtcBetweenAndType(start: Instant, end: Instant, type: Int): List<News>
}
