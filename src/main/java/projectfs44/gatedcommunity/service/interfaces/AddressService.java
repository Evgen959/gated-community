package projectfs44.gatedcommunity.service.interfaces;

import projectfs44.gatedcommunity.model.dto.AddressDTO;

import java.util.List;

public interface AddressService {



     AddressDTO saveAddress( AddressDTO addressDTO) ;

     AddressDTO getAddressById( long id) ;

     AddressDTO updateAddressById( Long id, AddressDTO addressDTO) ;

     List<AddressDTO> getAllAddress() ;

    AddressDTO deleteAddressById (Long id) ;


}
