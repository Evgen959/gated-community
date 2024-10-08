package gatedcommunity.security.filter;

import gatedcommunity.security.AuthInfo;
import gatedcommunity.security.service.TokenService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
public class TokenFilter extends GenericFilterBean {
 private final TokenService tokenService;

    public TokenFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = getTokenFromRequest(httpServletRequest);

        try {
            if (token != null && tokenService.validateAccessToken(token)) {
                Claims claims = tokenService.getAccessClaims(token);
                AuthInfo authInfo = tokenService.mapClaimsToAuthInfo(claims);

                authInfo.setAuthenticated(true);
                SecurityContextHolder.getContext().setAuthentication(authInfo);

                System.out.println("Authentication successful for token: " + token);
            } else {
                System.out.println("Authentication failed: Invalid or missing token");
            }
        } catch (Exception e) {
            System.out.println("Error during token validation: " + e.getMessage());
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }


    private String getTokenFromRequest(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
