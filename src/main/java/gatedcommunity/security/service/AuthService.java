package gatedcommunity.security.service;


import gatedcommunity.security.dto.LoginRequestDto;
import gatedcommunity.security.dto.RefreshRequestDto;
import gatedcommunity.security.dto.TokenResponseDto;
import io.jsonwebtoken.Claims;
import jakarta.security.auth.message.AuthException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final UserDetailsService userService;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final Map<String, String> refreshStorage;

    public AuthService(UserDetailsService userService, TokenService tokenService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.refreshStorage = new HashMap<>();
    }


    public TokenResponseDto login(LoginRequestDto loginRequestDto) throws AuthException {
        UserDetails foundUser = userService.loadUserByUsername(loginRequestDto.username());

        if (passwordEncoder.matches(loginRequestDto.password(), foundUser.getPassword())) {
            String accessToken = tokenService.generateAccessToken(foundUser);
            String refreshToken  = tokenService.generateRefreshToken(foundUser);

            refreshStorage.put(foundUser.getUsername(), refreshToken);

            return new TokenResponseDto(accessToken, refreshToken);
        }

        throw new AuthException("Incorrect login and / or password");
    }


    public TokenResponseDto refreshAccessToken(RefreshRequestDto refreshRequestDto) throws AuthException {
        String token = refreshRequestDto.refreshToken();

        boolean isValid = tokenService.validateRefreshToken(token);

        Claims refreshClaims = tokenService.getRefreshClaims(token);
        String username = refreshClaims.getSubject();

        String savedToken = refreshStorage.get(username);

        boolean isSaved = token.equals(savedToken);
        if (isValid && isSaved) {
            UserDetails founderUser = userService.loadUserByUsername(username);
            String accessToken = tokenService.generateAccessToken(founderUser);

            return new TokenResponseDto(accessToken, token);
        }
        throw new AuthException("Invalid refresh token. RE login please!");


    }
}
