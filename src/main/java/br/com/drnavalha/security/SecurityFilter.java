//package br.com.drnavalha.security;
//
//import br.com.drnavalha.service.AuthenticationService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.token.TokenService;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@Slf4j
//public class SecurityFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private TokenService tokenService;
//
//    @Autowired
//    private AuthenticationService authenticationService;
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        var tokenJWT = getTokenJWT(request);
//        if(tokenJWT != null){
//            var subject = tokenService.getSubject(tokenJWT);
//            var user = authenticationService.loadUserByUsername(subject);
//
//            var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//            SecurityContextHolder
//                    .getContext()
//                    .setAuthentication(auth);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    private String getTokenJWT(HttpServletRequest request) {
//
//        if (request.getRequestURI().endsWith("login")){
//            log.info( "REQUEST getRequestURI : {}", request.getRequestURI() );
//            return null;
//        }
//
//        var authorization = request.getHeader("Authorization");
//        if(authorization != null){
//            return authorization.replace("Bearer ","");
//        }
//        return null;
//    }
//}
