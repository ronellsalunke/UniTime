package ronell.timetable.data

data class UniData(
    val subject: String,
    val timeslot: String,
    val topics: String
)

object UniDataObj {
    val uniData: List<UniData> = listOf(
        UniData(
            "Artificial Intelligence",
            "12 Apr, 10:00 AM",
            "First Order Logic, Forward and Backward Chaining"
        ),
        UniData(
            "Enterprise Java",
            "13 Apr, 11:00 AM",
            "Working with Cookies, Non-Blocking I/O"
        ),
        UniData(
            "Microprocessor Architecture",
            "15 Apr, 12:00 PM",
            "Introduction to 8085"
        ),
        UniData(
            "Operating Systems",
            "16 Jun, 11:00 AM",
            "Paging"
        ),
        UniData(
            "Cyber Laws",
            "16 Jun, 12:00 PM",
            "IT Act, 2000"
        ),
        UniData(
            "Web Programming",
            "17 Jun, 11:00 AM",
            "CSS"
        ),
        UniData(
            "Internet of Things",
            "18 Jun, 10:00 AM",
            "Raspberry Pi model B"
        ),
        UniData(
            "Database Management Systems",
            "19 Jun, 10:00 AM",
            "Entities"
        )
    )
}