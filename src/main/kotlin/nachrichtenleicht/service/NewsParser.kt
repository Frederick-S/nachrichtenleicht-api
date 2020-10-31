package nachrichtenleicht.service

import com.apptastic.rssreader.Item
import nachrichtenleicht.entity.News
import org.springframework.stereotype.Service

@Service
class NewsParser {
    fun parse(item: Item): News {
        return News()
    }
}