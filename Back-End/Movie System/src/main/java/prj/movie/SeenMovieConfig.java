package prj.movie;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "prj.movie.repositories")
@EntityScan(basePackages = "prj.movie.data")
public class SeenMovieConfig {
}
