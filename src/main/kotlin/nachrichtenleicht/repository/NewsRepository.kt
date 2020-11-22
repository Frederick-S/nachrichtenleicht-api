package nachrichtenleicht.repository

import nachrichtenleicht.entity.News
import org.springframework.data.jpa.repository.JpaRepository

interface NewsRepository : JpaRepository<News, Int> {
}