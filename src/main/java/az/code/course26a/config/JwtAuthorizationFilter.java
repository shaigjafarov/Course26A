//package az.code.course26a.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
////import org.springframework.security.authentication.AuthenticationServiceException;
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.core.Authentication;
////import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class JwtAuthorizationFilter extends OncePerRequestFilter {
//
//    private final JwtUtil jwtUtil;
//    private final ObjectMapper mapper;
//
//    public JwtAuthorizationFilter(JwtUtil jwtUtil, ObjectMapper mapper) {
//        this.jwtUtil = jwtUtil;
//        this.mapper = mapper;
//    }
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        Map<String, Object> errorDetails = new HashMap<>();
//
//        try {
//            String accessToken = jwtUtil.resolveToken(request);
//            if (accessToken == null && request.getServletPath().startsWith("/auth/login") ) {
//                filterChain.doFilter(request, response);
//                return;
//            }
//            System.out.println("token : "+accessToken);
//            Claims claims = jwtUtil.resolveClaims(request);
//
//            if(claims != null & jwtUtil.validateClaims(claims)){
//                String email = claims.getSubject();
//                System.out.println("email : "+email);
////                Authentication authentication =
////                        new UsernamePasswordAuthenticationToken(email,"",new ArrayList<>());
////                SecurityContextHolder.getContext().setAuthentication(authentication);
//
//           }
//            Authentication authentication =
//                        new UsernamePasswordAuthenticationToken("sdv","",new ArrayList<>());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        filterChain.doFilter(request, response);
//    }
//}