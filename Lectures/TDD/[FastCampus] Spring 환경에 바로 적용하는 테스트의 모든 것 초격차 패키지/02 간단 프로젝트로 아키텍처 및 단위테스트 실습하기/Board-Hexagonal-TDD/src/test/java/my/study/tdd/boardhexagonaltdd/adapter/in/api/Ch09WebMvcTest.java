package my.study.tdd.boardhexagonaltdd.adapter.in.api;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import my.study.tdd.boardhexagonaltdd.common.exception.AccessDeniedException;
import my.study.tdd.boardhexagonaltdd.common.exception.ResourceNotFoundException;
import my.study.tdd.boardhexagonaltdd.domain.adapter.in.api.ArticleController;
import my.study.tdd.boardhexagonaltdd.domain.adapter.in.api.dto.ArticleDto;
import my.study.tdd.boardhexagonaltdd.domain.application.port.in.CreateArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.application.port.in.DeleteArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.application.port.in.GetArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.application.port.in.ModifyArticleUseCase;
import my.study.tdd.boardhexagonaltdd.domain.ArticleFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// UnitTest로 진행할 수 도 있지만 설정하는데 여러모로 불편(jackson, ControllerAdvice, converter, pageable, validation 등)
// Spring에서는 WebMvcTest를 써도 단위 테스트로 취급을 해줌
@WebMvcTest(controllers = ArticleController.class)
class Ch09WebMvcTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private GetArticleUseCase getArticleUseCase;
  @MockBean
  private CreateArticleUseCase createArticleUseCase;
  @MockBean
  private ModifyArticleUseCase modifyArticleUseCase;
  @MockBean
  private DeleteArticleUseCase deleteArticleUseCase;

  @Nested
  @DisplayName("GET /articles/{articleId}")
  class GetArticle {
    @Test
    @DisplayName("Article이 있으면, 200 OK return repsonse")
    void returnResponse() throws Exception {
      var article = ArticleFixtures.article();
      given(getArticleUseCase.getArticleById(any()))
          .willReturn(article);

      Long articleId = 1L;
      mockMvc
          .perform(get("/articles/{articleId}", articleId))
          .andDo(print())
          .andExpect(status().isOk());
    }

    @Test
    @DisplayName("articleId 에 해당하는 Article이 없으면 400 Not Found")
    void articleNotFound() throws Exception {
      given(getArticleUseCase.getArticleById(any()))
          .willThrow(new ResourceNotFoundException("Article not found"));

      Long articleId = 1L;
      mockMvc.perform(get("/articles/{articleId}", articleId))
          .andDo(print())
          .andExpect(status().isNotFound());
    }
  }

  @Test
  @DisplayName("GET /articles?boardId={boardId}")
  void listArticlesByBoard() throws Exception {
    given(getArticleUseCase.getArticlesByBoard(any()))
        .willReturn(List.of(ArticleFixtures.article(1L), ArticleFixtures.article(2L)));

    mockMvc.perform(get("/articles?boardId={boardId}", 5L))
        .andDo(print())
        .andExpect(
            status().isOk()
        );
  }

  @Nested
  @DisplayName("POST /articles")
  class PostArticle {

    @Test
    @DisplayName("생성된 articleId 반환")
    void returnArticleId() throws Exception {
      var createdArticle = ArticleFixtures.article();
      given(createArticleUseCase.createArticle(any()))
          .willReturn(createdArticle);

      var body = objectMapper.writeValueAsString(
          Map.of(
              "boardId", 5L,
              "subject", "subject",
              "content", "content",
              "username", "user"
          )
      );

      mockMvc.perform(
              post("/articles")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(body)
          )
          .andDo(print())
          .andExpect(status().isOk());

    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("비정상 패러미터이면 BadRequest")
    @CsvSource(
        value = {
            "subject is null,,content,user",
            "content is null,subject,,user",
            "username is null,subject,content,",
            "username is empty,subject,content,''"
        }
    )
    void invalidParam_BadRequest(String desc, String subject, String content, String username) throws Exception {
      var body = objectMapper.writeValueAsString(
          new ArticleDto.CreateArticleRequest(
              5L,
              subject,
              content,
              username
          )
      );
      mockMvc.perform(
              post("/articles")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(body)
          )
          .andDo(print())
          .andExpect(
              status().isBadRequest()
          );
    }
  }

  @Nested
  @DisplayName("PUT /articles")
  class PutArticle {
    @Test
    @DisplayName("변경된 Article의 articleId 반환")
    void returnArticleId() throws Exception {
      var modifiedArticle = ArticleFixtures.article();
      given(modifyArticleUseCase.modifyArticle(any()))
          .willReturn(modifiedArticle);

      var body = objectMapper.writeValueAsString(
          Map.of("id", 1L,
              "board", Map.of(
                  "id", 5L,
                  "name", "board"
              ),
              "subject", "new subject",
              "content", "new content",
              "username", "user"
          )
      );
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource(
        value = {
            "subject is null,,content,user",
            "content is null,subject,,user"
        }
    )
    void invalidParam_BadRequest(String desc, String subject, String content, String username) throws Exception {
      var body = objectMapper.writeValueAsString(new ArticleDto.CreateArticleRequest(5L, subject, content, username));
      mockMvc
          .perform(
              put("/articles")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(body)
          )
          .andDo(print())
          .andExpect(
              status().isBadRequest()
          );
    }

    @Test
    void otherUser_Forbidden() throws Exception {
      given(modifyArticleUseCase.modifyArticle(any()))
          .willThrow(new AccessDeniedException("다른 작성자는 수정 불가능"));

      var body = objectMapper.writeValueAsString(
          Map.of(
              "id", 1L,
              "board", Map.of(
                  "id", 5L,
                  "name", "board"
              ),
              "subject", "new subject",
              "content", "new content",
              "username", "otheruser"
          )
      );
      mockMvc
          .perform(
              put("/articles")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(body)
          )
          .andDo(print())
          .andExpect(
              status().isForbidden()
          );
    }
  }

  @Test
  @DisplayName("DELETE /articles/{articleId}")
  void deleteArticle() throws Exception {
    willDoNothing().given(deleteArticleUseCase).deleteArticle(any());

    mockMvc.perform(delete("/articles/{articleId}", 1L))
        .andDo(print())
        .andExpect(
            status().isOk()
        );

    verify(deleteArticleUseCase).deleteArticle(1L);
  }
}

