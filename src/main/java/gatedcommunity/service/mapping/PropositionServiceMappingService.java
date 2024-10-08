package gatedcommunity.service.mapping;

import gatedcommunity.model.dto.PropositionServiceDTO;
import gatedcommunity.model.dto.UserRequestDTO;
import gatedcommunity.model.entity.PropositionService;
import gatedcommunity.model.entity.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PropositionServiceMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "image", ignore = true)
    PropositionService mapDtoToEntity(PropositionServiceDTO dto);

    PropositionServiceDTO mapEntityToDto(PropositionService entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    void mapDTOToEntityUpdate(PropositionServiceDTO propositionServiceDTO, @MappingTarget PropositionService propositionService);

}






