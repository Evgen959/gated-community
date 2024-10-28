package projectfs44.gatedcommunity.service;

import projectfs44.gatedcommunity.exception_handling.exceptions.FirstTestException;
import projectfs44.gatedcommunity.exception_handling.exceptions.TextException;
import projectfs44.gatedcommunity.model.dto.AddressDTO;
import projectfs44.gatedcommunity.model.entity.Address;
import projectfs44.gatedcommunity.repository.AddressRepository;
import projectfs44.gatedcommunity.service.interfaces.AddressService;
import projectfs44.gatedcommunity.service.mapping.AddressMappingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMappingService addressMappingService;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMappingService addressMappingService) {
        this.addressRepository = addressRepository;
        this.addressMappingService = addressMappingService;
    }


    @Override
    public AddressDTO saveAddress(AddressDTO addressDTO) {

        Address address = addressMappingService.mapDtoToEntity(addressDTO);
       // address.setActive(true);
        return addressMappingService.mapEntityToDto(addressRepository.save(address));
    }

    @Override
    public AddressDTO getAddressById(long id) {

        Address address = addressRepository.findById(id).orElse(null);
        if (address == null) {
            throw new TextException("Address with id " + id + " not found");
        }
        if (!address.isActive()) {
            System.out.println("Address not active");
            throw new FirstTestException("Address not active!!!"); // подумать
        }
        return addressMappingService.mapEntityToDto(address);
    }

    @Override
    public List<AddressDTO> getAllAddress() {

        return addressRepository.findAll().stream()
                .filter(Address::isActive)
                .map(addressMappingService::mapEntityToDto)
                .toList();
    }

    @Override
    public AddressDTO updateAddressById(Long id, AddressDTO addressDTO) {

        Address address = addressRepository.findById(id).orElse(null);

        address.setStreet(addressDTO.getStreet());
        address.setNumberHouse(addressDTO.getNumberHouse());
        address.setCity(addressDTO.getCity());
        address.setIndex(addressDTO.getIndex());
        address.setActive(addressDTO.isActive());

        return addressMappingService.mapEntityToDto(addressRepository.save(address));

    }

    @Override
    public AddressDTO deleteAddressById(Long id) {

        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            addressRepository.deleteById(id);
        }
        return addressMappingService.mapEntityToDto(address);
    }
}
