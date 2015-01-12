package hello;

import hello.model.User;
import hello.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public InitializingBean poopulateTestData(final UserRepository userRepository) {
        return new InitializingBean() {
            @Override
            public void afterPropertiesSet() throws Exception {
                userRepository.save(new User("Dan", "Mikita"));
                userRepository.save(new User("Carlus", "Henry"));
                userRepository.save(new User("Eric", "Fox"));
            }
        };

    }

}
