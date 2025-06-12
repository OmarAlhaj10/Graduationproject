package org.example.blog.config;

import org.example.blog.domain.entities.User;
import org.example.blog.repositories.UserRepository;
import org.example.blog.security.BlogUserDetailService;
import org.example.blog.security.JwtAuthenticationFilter;
import org.example.blog.services.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(AuthenticationService authenticationService) {
        return new JwtAuthenticationFilter(authenticationService);
    }

    @Bean
    public UserDetailsService  userDetailsService(UserRepository userRepository) {
        BlogUserDetailService blogUserDetailService = new BlogUserDetailService(userRepository);

        String email = "admin@email.com";
        userRepository.findByEmail(email).orElseGet(() -> {
            User newUser = User.builder()
                    .name("admin")
                    .email(email)
                    .password(passwordEncoder().encode("123"))
                    .build();
            return userRepository.save(newUser);
        });

        String email2 = "omar@email.com";
        userRepository.findByEmail(email2).orElseGet(() -> {
            User newUser = User.builder()
                    .name("omar")
                    .email(email2)
                    .password(passwordEncoder().encode("123"))
                    .build();
            return userRepository.save(newUser);
        });

        String email3 = "ali@email.com";
        userRepository.findByEmail(email3).orElseGet(() -> {
            User newUser = User.builder()
                    .name("ali")
                    .email(email3)
                    .password(passwordEncoder().encode("123"))
                    .build();
            return userRepository.save(newUser);
        });

        String email4 = "seif@email.com";
        userRepository.findByEmail(email4).orElseGet(() -> {
            User newUser = User.builder()
                    .name("seif")
                    .email(email4)
                    .password(passwordEncoder().encode("123"))
                    .build();
            return userRepository.save(newUser);
        });

        String email5 = "shehab@email.com";
        userRepository.findByEmail(email5).orElseGet(() -> {
            User newUser = User.builder()
                    .name("shehab")
                    .email(email5)
                    .password(passwordEncoder().encode("123"))
                    .build();
            return userRepository.save(newUser);
        });

        return blogUserDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/v1/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/v1/categories/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/v1/categories/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/categories/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/tags/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/tags/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/tags/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/v1/posts/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/posts/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/posts/**").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
