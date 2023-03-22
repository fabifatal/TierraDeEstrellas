package com.tierra_de_estrellas.tierradeestrellas.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tierra_de_estrellas.tierradeestrellas.service.MyUserDetailsServices;

@Component
public class JwtFilter extends OncePerRequestFilter{

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsServices myUserDetailsServices;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException{
                String authorization = request.getHeader("Authorization");
                String username = null;
                String jwtToken =  null;

                if(authorization != null && authorization.startsWith("Bearer ")) {
                    jwtToken = authorization.substring(7);
                    username = jwtUtil.getUsernameFromToken(jwtToken);
            }

            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = myUserDetailsServices.loadUserByUsername(username);
            

                if(jwtUtil.validateToken(jwtToken, userDetails)) {
                    UsernamePasswordAuthenticationToken  usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken( userDetails, null, userDetails.getAuthorities());

                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }

            }
            chain.doFilter(request, response);
        }   
}
