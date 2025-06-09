package swp391.project.DeliverySystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // tắt CSRF toàn cục
                .csrf(csrf -> csrf.disable())

                // cấu hình phân quyền
                .authorizeHttpRequests(auth -> auth
                        // cho phép GET/POST tới /api/storages/** mà không cần auth
                        .requestMatchers(HttpMethod.GET,  "/api/storages/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/storages/**").permitAll()
                        // các endpoint khác bắt buộc phải xác thực
                        .anyRequest().authenticated()
                )

                // bật HTTP Basic (để test qua Postman nếu cần)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
