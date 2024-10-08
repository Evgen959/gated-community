package projectfs44.gatedcommunity.repository;

import projectfs44.gatedcommunity.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {


 /*   List<Address> findAddressById (Long id);*/
   /* List<Address> findAddress(Long id);*/
}
