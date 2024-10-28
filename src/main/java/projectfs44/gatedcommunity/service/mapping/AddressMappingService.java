package projectfs44.gatedcommunity.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import projectfs44.gatedcommunity.model.dto.AddressDTO;
import projectfs44.gatedcommunity.model.entity.Address;

@Mapper(componentModel = "spring")
public interface AddressMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    Address mapDtoToEntity(AddressDTO dto);

    AddressDTO mapEntityToDto(Address entity);

}
