package projectfs44.gatedcommunity.model.dto;

public record UserRegisterDTO(String userName,
                              String password,
                              String email,
                              String firstName,
                              String lastName) {
}