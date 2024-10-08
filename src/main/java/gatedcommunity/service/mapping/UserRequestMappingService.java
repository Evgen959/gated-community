package gatedcommunity.service.mapping;

import gatedcommunity.model.dto.UserRequestDTO;
import gatedcommunity.model.entity.UserRequest;
import gatedcommunity.service.interfaces.PropositionServiceService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class UserRequestMappingService {

    @Autowired
    private PropositionServiceService propositionService;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    public abstract UserRequest mapDTOToEntity(UserRequestDTO userRequestDTO);

    public abstract UserRequestDTO mapEntityToDTO(UserRequest entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    public abstract void mapDTOToEntityUpdate(UserRequestDTO userRequestDTO, @MappingTarget UserRequest userRequest);

    // Logic for mapping add propositionServiceTitle after map
    @AfterMapping
    protected void afterMapping(@MappingTarget UserRequestDTO userRequestDTO, UserRequest userRequest) {
        String propositionServiceTitle = propositionService
                .getPropositionServiceById(userRequest.getPropositionServiceId())
                .getTitle();
        userRequestDTO.setPropositionServiceTitle(propositionServiceTitle);
    }
}