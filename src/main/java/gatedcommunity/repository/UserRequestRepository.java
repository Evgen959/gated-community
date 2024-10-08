package gatedcommunity.repository;

import gatedcommunity.model.entity.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRequestRepository extends JpaRepository<UserRequest, Long> {

}
