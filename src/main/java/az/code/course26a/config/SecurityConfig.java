package az.code.course26a.config;

import az.code.course26a.repository.UserRepository;
import az.code.course26a.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    


    public SecurityConfig( UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .antMatchers("/public/**").permitAll() // Publicly accessible URLs
//                    .anyRequest().authenticated() // All other URLs require authentication
//            )
//            .formLogin(withDefaults()); // Default login form
//
//        return http.build();
//    }
//
//    @Bean
//    public SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .antMatchers("/admin/**").hasRole("ADMIN") // Admin URLs require ADMIN role
//                    .antMatchers("/user/**").hasRole("USER") // User URLs require USER role
//            )
//            .formLogin(withDefaults()); // Default login form
//
//        return http.build();
//    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }



        @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
//                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/employee/**").hasRole("USER")
                                .requestMatchers("/student/**").hasRole("USER")
                                .requestMatchers("/login_reg/**").permitAll()
                                .anyRequest().authenticated()
                ).httpBasic(withDefaults());

        http.authenticationProvider(authenticationProvider());

//        http.addFilterBefore(new JwtAuthorizationFilter(new JwtUtil(), new ObjectMapper()), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
