package gatedcommunity.service.mapping;

import gatedcommunity.model.dto.AddressDTO;
import gatedcommunity.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMappingService {

        @Mapping(target = "id", ignore = true)
        @Mapping(target = "active", constant = "true")
        Address mapDtoToEntity(AddressDTO dto);

    AddressDTO mapEntityToDto(Address entity);



}
