// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }

// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//             // ✅ REST API → no sessions
//             .sessionManagement(session ->
//                 session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//             )

//             // ✅ Disable CSRF
//             .csrf(csrf -> csrf.disable())

//             // ✅ Disable default login mechanisms
//             .formLogin(form -> form.disable())
//             .httpBasic(basic -> basic.disable())

//             // ✅ Authorization rules
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers(
//                         "/api/users/register",
//                         "/api/users/login",
//                         "/v3/api-docs/**",
//                         "/swagger-ui/**",
//                         "/swagger-ui.html"
//                 ).permitAll()
//                 .anyRequest().authenticated()
//             );

//         return http.build();
//     }
// }


// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//             // Disable CSRF for REST APIs
//             .csrf(csrf -> csrf.disable())

//             // Disable default login mechanisms
//             .formLogin(form -> form.disable())
//             .httpBasic(basic -> basic.disable())

//             // Authorization rules
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers(
//                         "/api/users/**",        // ✅ allow register + get user
//                         "/v3/api-docs/**",      // swagger
//                         "/swagger-ui/**",
//                         "/swagger-ui.html"
//                 ).permitAll()
//                 .anyRequest().authenticated()
//             );

//         return http.build();
//     }
// }
 

 package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // REST API → no CSRF
            .csrf(csrf -> csrf.disable())

            // Disable default login mechanisms
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/api/users/**",           // users (register, get)
                        "/api/priority-rules/**",  // ✅ FIX (compute, active)
                        "/api/complaints/**",      // complaints (if any)
                        "/v3/api-docs/**",         // swagger
                        "/swagger-ui/**",
                        "/swagger-ui.html"
                ).permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
