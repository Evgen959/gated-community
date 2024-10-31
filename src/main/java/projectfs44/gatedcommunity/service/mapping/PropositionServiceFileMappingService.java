package projectfs44.gatedcommunity.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import projectfs44.gatedcommunity.model.dto.PropositionServiceFileDTO;
import projectfs44.gatedcommunity.model.entity.PropositionServiceFile;

@Mapper(componentModel = "spring")
public interface PropositionServiceFileMappingService {

//    @Mapping(target = "id", ignore = true)
//    PropositionServiceFile mapDtoToEntity(PropositionServiceFileDTO dto);
//
//    PropositionServiceFileDTO mapEntityToDto(PropositionServiceFile entity);
//
//    @Mapping(target = "id", ignore = true)
//    void mapDTOToEntityUpdate(PropositionServiceFileDTO propositionServiceFileDTO,
//                              @MappingTarget PropositionServiceFile propositionServiceFile);
}
