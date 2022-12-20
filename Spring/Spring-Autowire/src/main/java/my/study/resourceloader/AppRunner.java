package my.study.resourceloader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  ResourceLoader resourceLoader;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Resource resource = resourceLoader.getResource("classpath:test.txt");
    System.out.println(resource.exists()); // true
    System.out.println(resource.getDescription()); // class path resource [test.txt]
    System.out.println(Files.readString(Path.of(resource.getURI()))); // Hello Spring!
  }
}
