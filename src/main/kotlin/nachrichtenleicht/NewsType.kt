package nachrichtenleicht

enum class NewsType(val feedUrl: String, val type: Int) {
    NACHRICHTEN("http://www.nachrichtenleicht.de/nachrichten.2005.de.rss", 1),
    KULTUR("http://www.nachrichtenleicht.de/kultur.2006.de.rss", 2),
    VERMISCHTES("http://www.nachrichtenleicht.de/vermischtes.2007.de.rss", 3),
    SPORT("http://www.nachrichtenleicht.de/sport.2004.de.rss", 4)
}
