package gatedcommunity.controller;

import gatedcommunity.exception_handling.Response;
import gatedcommunity.service.interfaces.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/confirm")
public class ConfirmController {

    private final UserService userService;

    public ConfirmController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Response confirmEmail(@RequestParam String code) {
        return new Response(userService.confirmationMailByCode(code));
    }
}
