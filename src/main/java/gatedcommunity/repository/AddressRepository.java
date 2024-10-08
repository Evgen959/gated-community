package gatedcommunity.repository;

import gatedcommunity.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {


 /*   List<Address> findAddressById (Long id);*/
   /* List<Address> findAddress(Long id);*/
}
