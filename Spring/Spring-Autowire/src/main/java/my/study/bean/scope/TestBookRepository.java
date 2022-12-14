package my.study.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("test")
public class TestBookRepository implements BookRepository {

}
