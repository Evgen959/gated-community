package projectfs44.gatedcommunity.service.interfaces;

import projectfs44.gatedcommunity.model.dto.UserRequestDTO;
import java.util.List;

public interface  UserRequestService {

    void attachPhoto(String photoUrl, String description);

    UserRequestDTO saveUserRequest(UserRequestDTO userRequestDTO);

    UserRequestDTO getUserRequestById(long id);

    List<UserRequestDTO> getAllUserRequest();

    UserRequestDTO updateUserRequest(Long id, UserRequestDTO userRequestDTO);

    UserRequestDTO deleteUserRequestById(Long id);

    UserRequestDTO restoreUserRequestById(Long id);

    UserRequestDTO removeUserRequestById(Long id);





}
