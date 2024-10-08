package gatedcommunity.service.mapping;


import gatedcommunity.model.dto.UserDTO;
import gatedcommunity.model.dto.UserRegisterDTO;
import gatedcommunity.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    User mapDTOToEntity(UserDTO userDTO);
    UserDTO mapEntityToDTO(User entity);
    User mapRegisterDTOToEntity(UserRegisterDTO userRegisterDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    void mapDTOToEntityUpdate(UserDTO userDTO, @MappingTarget User user);


}
