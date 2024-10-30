package projectfs44.gatedcommunity.service.mapping;

import projectfs44.gatedcommunity.model.dto.PropositionServiceDTO;
import projectfs44.gatedcommunity.model.dto.PropositionServiceFileDTO;
import projectfs44.gatedcommunity.model.entity.PropositionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import projectfs44.gatedcommunity.model.entity.PropositionServiceFile;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

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

    // Добавляем маппинг для списка файлов
    default List<PropositionServiceFile> mapFileDTOsToEntities(List<PropositionServiceFileDTO> fileDTOs) {
        if (fileDTOs == null) {
            return null;
        }
        return fileDTOs.stream()
                .map(this::mapFileDTOToEntity) // вызов метода для маппинга отдельного файла
                .collect(Collectors.toList());
    }

    default PropositionServiceFileDTO mapFileEntityToDto(PropositionServiceFile file) {
        return new PropositionServiceFileDTO(
                file.getId(),
                Base64.getEncoder().encodeToString(file.getFileData()), // Кодируем в Base64
                file.getPropositionService().getId()
        );
    }

    default PropositionServiceFile mapFileDTOToEntity(PropositionServiceFileDTO fileDTO) {
        return new PropositionServiceFile(
                fileDTO.id(),
                Base64.getDecoder().decode(fileDTO.fileData()), // Декодируем из Base64
                null // Установите соответствующий идентификатор услуги позже
        );
    }
}






//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "active", constant = "true")
//    @Mapping(target = "image", ignore = true)
//    PropositionService mapDtoToEntity(PropositionServiceDTO dto);
//
//    PropositionServiceDTO mapEntityToDto(PropositionService entity);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "active", ignore = true)
//    void mapDTOToEntityUpdate(PropositionServiceDTO propositionServiceDTO, @MappingTarget PropositionService propositionService);
//
//}






