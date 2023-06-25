package ar.com.itau.event.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@Configuration
@ConfigurationProperties("seed")
public class Config {

    @NotBlank
    private String prefix;
    private SWCharacterRepositoryConfig characterRepository;
    private UserApiRepository userRepository;

    @Data
    public static class SWCharacterRepositoryConfig {
        @NotBlank
        private String url;
    }

    @Data
    public static class UserApiRepository {
        @NotBlank
        private String url;
    }

}
