package gatedcommunity.service.interfaces;

import gatedcommunity.model.dto.AddressDTO;
import gatedcommunity.model.entity.Address;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AddressService {



     AddressDTO saveAddress( AddressDTO addressDTO) ;

     AddressDTO getAddressById( long id) ;

     AddressDTO updateAddressById( Long id, AddressDTO addressDTO) ;

     List<AddressDTO> getAllAddress() ;

    AddressDTO deleteAddressById (Long id) ;


}
