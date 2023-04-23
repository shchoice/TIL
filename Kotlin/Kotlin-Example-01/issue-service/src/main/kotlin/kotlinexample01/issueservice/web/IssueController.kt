package kotlinexample01.issueservice.web

import kotlinexample01.issueservice.config.AuthUser
import kotlinexample01.issueservice.domain.enums.IssueStatus
import kotlinexample01.issueservice.model.IssueRequest
import kotlinexample01.issueservice.model.IssueResponse
import kotlinexample01.issueservice.service.IssueService
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/issues")
class IssueController(
    private val issueService: IssueService,
) {

    @PostMapping
    fun create(
        authUser: AuthUser,
        @RequestBody request: IssueRequest,
    ) = issueService.create(authUser.userId, request)

    @GetMapping
    fun getAll(
        authUser: AuthUser,
        @RequestParam(required = false, defaultValue = "TODO") status : IssueStatus,
    ) = issueService.getAll(status)


    @GetMapping("/{id}")
    fun get(
        authUser: AuthUser,
        @PathVariable id: Long,
    ) = issueService.get(id)

    @PutMapping("/{id}")
    fun edit(
        authUser: AuthUser,
        @PathVariable id : Long,
        @RequestBody request: IssueRequest,
    ) = issueService.edit(authUser.userId, id, request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete (
        authUser: AuthUser,
        @PathVariable id: Long,
    ) {
        issueService.delete(id)
    }
}