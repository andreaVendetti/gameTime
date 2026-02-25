package it.home.configures;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http
	        .csrf(csrf -> csrf.disable())

	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(
	                "/gametime/utenti/insert",
	                "/utente/edit",
	                "/gametime/utenti/save",
	                "/gametime/login",
	                "/login",
	                "/css/**",
	                "/js/**"
	            ).permitAll()
	            .anyRequest().authenticated()
	        )

	        .formLogin(form -> form
	            .loginPage("/gametime/login")
	            .loginProcessingUrl("/login")
	            .usernameParameter("email")
	            .defaultSuccessUrl("/gametime/home", true).failureUrl("/gametime/login?error")
	            .permitAll()
	        )

	        .logout(logout -> logout
	            .logoutSuccessUrl("/gametime/login")
	        );

	    return http.build();
	}

    @Bean
     PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
