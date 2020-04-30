package hu.unideb.eplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.server.core.EvoInflectorLinkRelationProvider;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EplannerApplication {

    public static String CURIE_NAMESPACE = "eplanner";

    /* public @Bean
     CurieProvider curieProvider() {
         return new DefaultCurieProvider(CURIE_NAMESPACE, UriTemplate.of("/docs/{rel}.html"));
     }*/
    @Bean
    EvoInflectorLinkRelationProvider relProvider() {
        return new EvoInflectorLinkRelationProvider();
    }

    public static void main(String[] args) {
        SpringApplication.run(EplannerApplication.class, args);
    }

}
