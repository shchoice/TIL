package my.stduy.springintroduction.repository;

import java.util.Optional;
import my.stduy.springintroduction.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
  Optional<Member> findByName(String name);
}
