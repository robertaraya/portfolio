package rbrt.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.authorizeHttpRequests(authorize -> authorize
        			.requestMatchers(HttpMethod.GET,"/api/pattern/**").permitAll()
        			.anyRequest().authenticated())
        	.httpBasic(withDefaults())
            .csrf((csrf) -> csrf.disable());

        return http.build();
    }
}
