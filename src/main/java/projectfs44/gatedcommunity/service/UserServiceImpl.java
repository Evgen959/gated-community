package projectfs44.gatedcommunity.service;

import projectfs44.gatedcommunity.model.dto.UserDTO;
import projectfs44.gatedcommunity.model.dto.UserRegisterDTO;
import projectfs44.gatedcommunity.model.entity.User;
import projectfs44.gatedcommunity.repository.UserRepository;
import projectfs44.gatedcommunity.service.interfaces.UserService;
import projectfs44.gatedcommunity.service.mapping.UserMappingService;
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
        return repository.findUserByUserName(name)
                .map(mapping::mapEntityToDTO)
                .orElseThrow(() -> new RuntimeException("User not found: " + name));

    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {

        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        mapping.mapDTOToEntityUpdate(userDTO, user);
        user.setActive(true);
        return mapping.mapEntityToDTO(repository.save(user));

    }

    @Override
    public UserDTO deleteUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        repository.deleteById(id);
        return mapping.mapEntityToDTO(user);
    }

    @Override
    public UserDTO restoreUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        user.setActive(true);
        return mapping.mapEntityToDTO(repository.save(user));
    }

    @Override
    public UserDTO removeUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found: " + id));
        user.setActive(false);
        return mapping.mapEntityToDTO(repository.save(user));
    }
}
