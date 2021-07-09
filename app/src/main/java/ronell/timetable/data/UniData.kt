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
        )
    )
}