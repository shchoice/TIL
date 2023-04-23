package kotlinexample01.issueservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class KotlinExample01Application

fun main(args: Array<String>) {
    runApplication<KotlinExample01Application>(*args)
}
