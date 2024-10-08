package projectfs44.gatedcommunity.controller;

import projectfs44.gatedcommunity.model.dto.UserRequestDTO;
import projectfs44.gatedcommunity.service.interfaces.UserRequestService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-request")
@Tag(name = "UserRequest controller", description = "Controller for operations wis UserRequest")
public class UserRequestController {

    private final UserRequestService userRequestService;

    public UserRequestController(UserRequestService userRequestService) {
        this.userRequestService = userRequestService;
    }

    public void attachPhoto(String picture, String description) {
    }

    @PostMapping
    public UserRequestDTO saveUserRequest(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userRequestService.saveUserRequest(userRequestDTO);
    }

    @GetMapping("/{id}")
    public UserRequestDTO getUserRequestById(
            @Parameter(description = "The ID of the user request to fetch", required = true)
            @PathVariable("id") long id) {
        return userRequestService.getUserRequestById(id);
    }

    @GetMapping
    public List<UserRequestDTO> getAllUserRequests() {
        return userRequestService.getAllUserRequest();
    }

    @PutMapping("/{id}")
    public UserRequestDTO updateUserRequest(
            @PathVariable("id") Long id,
            @Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userRequestService.updateUserRequest(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public UserRequestDTO deleteUserRequestById(@PathVariable("id") Long id) {
        return userRequestService.deleteUserRequestById(id);
    }

    @PutMapping("/restore/{id}")
    public UserRequestDTO restoreUserRequestById(@PathVariable("id") Long id) {
        return userRequestService.restoreUserRequestById(id);
    }

    @PutMapping("/remove/{id}")
    public UserRequestDTO removeUserRequestById(@PathVariable("id") Long id) {
        return userRequestService.removeUserRequestById(id);
    }
}



