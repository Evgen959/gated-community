package gatedcommunity.service.interfaces;

import gatedcommunity.model.dto.UserDTO;
import gatedcommunity.model.dto.UserRegisterDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService  {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void register(UserRegisterDTO registerDto);
    String confirmationMailByCode(String code);


    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(long id);
    UserDTO getUserByName(String name);
    UserDTO updateUser(Long id, UserDTO userDTO);
    UserDTO deleteUserById(Long id);
    UserDTO restoreUserById(Long id);
    UserDTO removeUserById(Long id);
}
