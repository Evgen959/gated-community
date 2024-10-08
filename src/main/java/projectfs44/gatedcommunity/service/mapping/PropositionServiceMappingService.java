package projectfs44.gatedcommunity.service.mapping;

import projectfs44.gatedcommunity.model.dto.PropositionServiceDTO;
import projectfs44.gatedcommunity.model.entity.PropositionService;
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






