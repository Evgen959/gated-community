package projectfs44.gatedcommunity.controller;


import projectfs44.gatedcommunity.model.dto.UserDTO;
import projectfs44.gatedcommunity.service.interfaces.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(
            @Parameter(description = "The id that needs to de fetch", required = true) @PathVariable("id") long id){

        //  обращаемся к сервису для получения сервиса по id
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/results")
    public UserDTO getUserByName(@RequestParam(required = false) String name){
        if (name != null) {
            return userService.getUserByName(name);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }
    }



    @PutMapping("/update/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public UserDTO deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

    @PutMapping("/restore/{id}")
    public UserDTO restoreUserById(@PathVariable Long id) {
        return userService.restoreUserById(id);
    }

    @PutMapping("/remove/{id}")
    public UserDTO removeUserById(@PathVariable Long id) {
        return userService.removeUserById(id);
    }
}


