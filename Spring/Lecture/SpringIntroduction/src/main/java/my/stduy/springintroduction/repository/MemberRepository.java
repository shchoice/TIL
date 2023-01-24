package my.stduy.springintroduction.repository;

import java.util.List;
import java.util.Optional;
import my.stduy.springintroduction.domain.Member;
import org.springframework.stereotype.Repository;

public interface MemberRepository {
  Member save(Member member);
  Optional<Member> findById(Long id);
  Optional<Member> findByName(String name);
  List<Member> findAll();
}
