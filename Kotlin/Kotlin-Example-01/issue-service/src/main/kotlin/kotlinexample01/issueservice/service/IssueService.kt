package kotlinexample01.issueservice.service

import kotlinexample01.issueservice.domain.Issue
import kotlinexample01.issueservice.domain.IssueRepository
import kotlinexample01.issueservice.domain.enums.IssueStatus
import kotlinexample01.issueservice.exception.NotFoundException
import kotlinexample01.issueservice.model.IssueRequest
import kotlinexample01.issueservice.model.IssueResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IssueService (
    private val issueRepository: IssueRepository,
){

    @Transactional
    fun create(userId: Long, request: IssueRequest): IssueResponse {
        val issue = Issue(
            summary = request.summary,
            description = request.description,
            userId = userId,
            type = request.type,
            priority = request.priority,
            status = request.status,
        )
        return IssueResponse.invoke(issueRepository.save(issue))
    }
    @Transactional
    fun getAll(status: IssueStatus) =
        issueRepository.findAllByStatusOrderByCreatedAtDesc(status)
            ?.map {IssueResponse(it)}

    @Transactional(readOnly = true)
    fun get(id: Long): IssueResponse {
        val issue = issueRepository.findByIdOrNull(id) ?: throw NotFoundException("이슈가 존재하지 않습니다")
        return IssueResponse(issue)
    }


}