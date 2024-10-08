package gatedcommunity.service;

import gatedcommunity.exception_handling.exceptions.TextException;
import gatedcommunity.model.dto.UserRequestDTO;
import gatedcommunity.model.entity.UserRequest;
import gatedcommunity.repository.UserRequestRepository;
import gatedcommunity.service.interfaces.PropositionServiceService;
import gatedcommunity.service.interfaces.UserRequestService;
import gatedcommunity.service.mapping.UserRequestMappingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRequestServiceImpl implements UserRequestService {

    private final PropositionServiceService propositionService;
    private final UserRequestRepository repository;
    private final UserRequestMappingService mapper;

    public UserRequestServiceImpl(PropositionServiceService propositionService, UserRequestRepository repository, UserRequestMappingService mapper) {
        this.propositionService = propositionService;
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public void attachPhoto(String picture, String description) {
    }

    @Override
    public UserRequestDTO saveUserRequest(UserRequestDTO userRequestDTO) {
        UserRequest userRequest = mapper.mapDTOToEntity(userRequestDTO);
        userRequest.setActive(true);
        System.out.println(userRequestDTO);
        System.out.println("s--------------33----------------3----------");
        System.out.println(userRequest);

        return mapper.mapEntityToDTO(repository.save(userRequest));

    }

    @Override
    public UserRequestDTO getUserRequestById(long id) {
        UserRequest userRequest = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User request not found for id: " + id));

        if (!userRequest.isActive()) {
            throw new TextException("User request with id " + id + " is not active");
        }
        return mapper.mapEntityToDTO(userRequest);
    }


    @Override
    public List<UserRequestDTO> getAllUserRequest() {
        return repository.findAll().stream()
                .filter(UserRequest::isActive)
                .map(mapper::mapEntityToDTO)
                .toList();
    }

    @Override
    public UserRequestDTO deleteUserRequestById(Long id) {
        UserRequest userRequest = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User request not found for id: " + id));

        repository.deleteById(id);
        return mapper.mapEntityToDTO(userRequest);
    }

    @Override
    public UserRequestDTO restoreUserRequestById(Long id) {
        UserRequest userRequest = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User request not found for id: " + id));

        userRequest.setActive(true);
        return mapper.mapEntityToDTO(repository.save(userRequest));
    }

    @Override
    public UserRequestDTO removeUserRequestById(Long id) {
        UserRequest userRequest = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User request not found for id: " + id));

        userRequest.setActive(false);
        return mapper.mapEntityToDTO(repository.save(userRequest));
    }

    @Override
    public UserRequestDTO updateUserRequest(Long id, UserRequestDTO userRequestDTO) {

        UserRequest userRequest = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User request not found for id: " + id));

        mapper.mapDTOToEntityUpdate(userRequestDTO, userRequest);  // Use mapper for update Entity

        userRequest.setActive(true);

        return mapper.mapEntityToDTO(repository.save(userRequest));

    }
}
