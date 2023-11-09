package eu.henok.document.converter;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFoxConfig {
  @Bean
  public GroupedOpenApi api() {
    return GroupedOpenApi.builder().group("convert").pathsToMatch("convert/**").build();
  }
}
