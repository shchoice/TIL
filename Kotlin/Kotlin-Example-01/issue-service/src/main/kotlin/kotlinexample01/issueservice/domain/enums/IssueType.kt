package kotlinexample01.issueservice.domain.enums

enum class IssueType {

    BUG, TASK;

    companion object {
        operator fun invoke(type:String) = valueOf(type.uppercase())

    }
}
