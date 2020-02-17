package anton.miranouski.user_management.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The type Web config.
 */
@Configuration
@EnableWebMvc
public class WebConfig {

    /**
     * Dozer bean mapper.
     *
     * @return the dozer bean mapper
     */
    @Bean
    public DozerBeanMapper mapper() {
        return new DozerBeanMapper();
    }

    /**
     * Password encoder.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
