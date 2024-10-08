package gatedcommunity.service;

import gatedcommunity.model.dto.UserDTO;
import gatedcommunity.model.dto.UserRegisterDTO;
import gatedcommunity.model.entity.User;
import gatedcommunity.repository.UserRepository;
import gatedcommunity.service.interfaces.UserService;
import gatedcommunity.service.mapping.UserMappingService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMappingService mapping;

    public UserServiceImpl(UserRepository repository, UserMappingService mapping) {
        this.repository = repository;
        this.mapping = mapping;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }


    @Override
    public void register(UserRegisterDTO registerDTO) {

    }


    @Override
    public String confirmationMailByCode(String code) {
        return "Email successfully confirmed!";
    }


    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = mapping.mapDTOToEntity(userDTO);
        user.setActive(true);
        return mapping.mapEntityToDTO(repository.save(user));

    }


    @Override
    public List<UserDTO> getAllUsers() {
        return repository.findAll().stream()
                .map(mapping::mapEntityToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public UserDTO getUserById(long id) {
        return repository.findById(id)
                .map(mapping::mapEntityToDTO)
                .orElseThrow(() -> new RuntimeException("The user with the ID was not found: " + id));
    }

    @Override
    public UserDTO getUserByName(String name) {
        return null;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO deleteUserById(Long id) {
        return null;
    }

    @Override
    public UserDTO restoreUserById(Long id) {
        return null;
    }

    @Override
    public UserDTO removeUserById(Long id) {
        return null;
    }
}
