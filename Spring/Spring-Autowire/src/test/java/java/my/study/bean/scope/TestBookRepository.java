package java.my.study.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("!prod & test")
public class TestBookRepository implements BookRepository {

}
