package kotlinexample01.issueservice.exception

data class ErrorResponse(
    val code: Int,
    val message: String,
)
