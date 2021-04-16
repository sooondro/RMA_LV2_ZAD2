package hr.ferit.sandroblavicki.rma_lv2_zad2

object PeopleRepository {

    private val people = mutableListOf<Person>(
        Person(1, "Bill Gates", "1955-10-28",
            listOf(
                "I choose a lazy person to do a hard job. Because a lazy person will find an easy way to do it.",
                "Don’t compare yourself with anyone in this world…if you do so, you are insulting yourself.",
                "Success is a lousy teacher. It seduces smart people into thinking they can’t lose."),
            "William Henry Gates III is an American business magnate, software developer, investor, author, landowner and philanthropist.",
            "https://pbs.twimg.com/profile_images/988775660163252226/XpgonN0X.jpg"
        ),
        Person(2, "Robert Cecil Martin", "1952-12-05",
            listOf(
                "Truth can only be found in one place: the code.",
                "It is not enough for code to work.",
                "So if you want to go fast, if you want to get done quickly, if you want your code to be easy to write, make it easy to read."),
            "Robert Cecil Martin, colloquially called \"Uncle Bob\", is an American software engineer, instructor, and best-selling author.",
            "https://media.itkonekt.com/2019/12/UncleBob.png"
        ),
        Person(3, "Barbara Liskov", "1939-11-07",
            listOf(
                "... the ingredients that have to be in place in order to get an ah hah moment. You have to be working on a problem, but also have to be able to have \"off time\" so that the brain can work on the back burner.",
                "I have no idea how I got that idea. […] It was ready to be discovered.",
                "You never need optimal performance, you need good-enough performance. [...] Programmers are far too hung up with performance."
            ), "Barbara Liskov was one of the first women to be granted a doctorate in computer science in the United States and is a Turing Award winner who developed the Liskov substitution principle.",
            "https://news.mit.edu/sites/default/files/styles/news_article__image_gallery/public/images/200903/20091222102310-0_0.jpg?itok=SqUZdhKC"
        )
    )



    fun remove(id: Int) = people.removeAll { person -> person.id == id }
    fun get(id: Int): Person? = people.find { person -> person.id == id }
    fun getPeople(): List<Person> = people
    fun add(person: Person) = people.add(person)
    fun generateId(): Int {
        return people.size + 1
    }
}