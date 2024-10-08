package projectfs44.gatedcommunity.controller;

import projectfs44.gatedcommunity.exception_handling.Response;
import projectfs44.gatedcommunity.model.dto.UserRegisterDTO;
import projectfs44.gatedcommunity.service.interfaces.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Response registerUser(@RequestBody UserRegisterDTO dto) {
        System.out.println(dto.toString());
        userService.register(dto);
        return new Response("Registration Complete. Please check your email");
    }
}
