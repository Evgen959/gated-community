package projectfs44.gatedcommunity.security.controller;



import projectfs44.gatedcommunity.exception_handling.Response;
import projectfs44.gatedcommunity.model.dto.UserRegisterDTO;
import projectfs44.gatedcommunity.security.dto.LoginRequestDto;
import projectfs44.gatedcommunity.security.dto.RefreshRequestDto;
import projectfs44.gatedcommunity.security.dto.TokenResponseDto;

import projectfs44.gatedcommunity.service.interfaces.UserService;
import jakarta.security.auth.message.AuthException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    // POST - /auth/login
    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            return authService.login(loginRequestDto);
        } catch (AuthException e) {
            throw new RuntimeException(e);
        }
    }


    @PostMapping("/refresh")
    public TokenResponseDto refreshAccessToken(@RequestBody RefreshRequestDto refreshRequestDto) {
        try {
            return authService.refreshAccessToken(refreshRequestDto);
        } catch (AuthException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/register")
    public Response register(@RequestBody UserRegisterDTO userRegisterDto) {
        userService.register(userRegisterDto);
        return new Response("Registration Complete. Please check your email");
    }

}









