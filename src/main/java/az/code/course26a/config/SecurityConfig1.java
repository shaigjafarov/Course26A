//package az.code.course26a.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////    @Autowired
////    JwtAuthorizationFilter jwtAuthorizationFilter;
////
//
//
//
////    private final CustomUserDetailsService userDetailsService;
//
////    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
////        this.userDetailsService = customUserDetailsService;
////
////    }
////    @Bean
////    public AuthenticationManager authenticationManager(HttpSecurity http, NoOpPasswordEncoder noOpPasswordEncoder)
////            throws Exception {
////        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
////        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(noOpPasswordEncoder);
////        return authenticationManagerBuilder.build();
////    }
//
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//////        http
//////                .authorizeHttpRequests((authz) -> authz
//////
//////                        .requestMatchers("/auth/**")
//////                        .permitAll()
//////
//////
//////                )
//////
//////                .httpBasic(withDefaults());
//////        return http.build();
////
//////        http
//////
//////                .antMatchers("/api/**") // only apply the security configuration to requests that start with /api
//////                .and()
//////                .authorizeHttpRequests()
//////                .antMatchers("/api/contenteditor/feed/**").hasAnyRole("SITE_ADMIN", "STANDARD_ADMIN", "DOMAIN_MEMBER")
//////                .and()
//////                .addFilterBefore(new CustomOncePerRequestFilter(), UsernamePasswordAuthenticationFilter.class)
//////                .cors()
//////                .disable()
//////                .build();
////    }
//
////    @Bean
////    public JwtAuthorizationFilter authenticationJwtTokenFilter() {
////        return new JwtAuthorizationFilter();
////    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
////                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
////                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/auth/**").permitAll()
//                                .anyRequest().authenticated()
//                );
//
////        http.authenticationProvider(authenticationProvider());
//
//        http.addFilterBefore(new JwtAuthorizationFilter(new JwtUtil(), new ObjectMapper()), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
////    @SuppressWarnings("deprecation")
////    @Bean
////    public NoOpPasswordEncoder passwordEncoder() {
////        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
////    }
//
//}