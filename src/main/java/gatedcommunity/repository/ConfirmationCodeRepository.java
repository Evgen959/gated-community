package gatedcommunity.repository;

import gatedcommunity.model.entity.ConfirmationCode;
import gatedcommunity.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmationCodeRepository extends JpaRepository<ConfirmationCode, Long> {

    Optional<ConfirmationCode> findByCode(String code);
    Optional<ConfirmationCode> findCodeByUser(User user);
}
