package projectfs44.gatedcommunity.security.controller;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import projectfs44.gatedcommunity.exception_handling.Response;
import projectfs44.gatedcommunity.model.dto.UserDTO;
import projectfs44.gatedcommunity.model.dto.UserRegisterDTO;
import projectfs44.gatedcommunity.security.dto.LoginRequestDto;
import projectfs44.gatedcommunity.security.dto.RefreshRequestDto;
import projectfs44.gatedcommunity.security.dto.TokenResponseDto;
import projectfs44.gatedcommunity.security.service.AuthService;
import projectfs44.gatedcommunity.service.interfaces.UserService;
import jakarta.security.auth.message.AuthException;


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

    @GetMapping("/me")
    public UserDTO getMe(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.getUserByName(username);
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









