package my.stduy.springintroduction.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import my.stduy.springintroduction.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MeomoryMemberRepositoryTest {

  MeomoryMemberRepository repository = new MeomoryMemberRepository();

  @AfterEach
  public void afterEach() {
    repository.cleaerStore();
  }

  @Test
  public void save() {
    // given
    Member member = new Member();
    member.setName("shchoi");

    // when
    repository.save(member);

    // then
    Member result = repository.findById(member.getId()).get();
    // Assertions.assertThat(member, result); JUnit5 로 검증 시
    assertThat(result).isEqualTo(member);
  }

  @Test
  public void findByName() {
    // given
    Member member01 = new Member();
    member01.setName("spring01");
    repository.save(member01);

    Member member02 = new Member();
    member02.setName("spring02");
    repository.save(member02);

    // when
    Member result = repository.findByName("spring01").get();

    // then
    assertThat(result).isEqualTo(member01);
  }

  @Test
  public void findAll() {
    // given
    Member member01 = new Member();
    member01.setName("spring01");
    repository.save(member01);

    Member member02 = new Member();
    member02.setName("spring02");
    repository.save(member02);

    // when
    List<Member> result = repository.findAll();

    // then
    assertThat(result.size()).isEqualTo(2);
  }
}