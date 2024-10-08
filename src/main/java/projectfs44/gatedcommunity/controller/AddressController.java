package projectfs44.gatedcommunity.controller;

import projectfs44.gatedcommunity.model.dto.AddressDTO;
import projectfs44.gatedcommunity.service.interfaces.AddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@Tag(name = "Address controller", description = "Controller for Address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {

        this.addressService = addressService;
    }

    @PostMapping
    public AddressDTO saveAddress(@Valid @RequestBody AddressDTO addressDTO) {

        return addressService.saveAddress(addressDTO);
    }

    @GetMapping("/{id}")
    AddressDTO getAddressById(@PathVariable("id") long id) {

        return addressService.getAddressById(id);
    };


    @PutMapping("/{id}")
    public AddressDTO updateAddressById(Long id, @RequestBody AddressDTO addressDTO) {

        return addressService.updateAddressById(id, addressDTO);
    }

    @GetMapping
    public List<AddressDTO> getAllAddress() {

        return addressService.getAllAddress();
    }

    @DeleteMapping("/{id}")
    public AddressDTO deleteAddressById(@PathVariable Long id) {

        return addressService.deleteAddressById(id);
    }

}
