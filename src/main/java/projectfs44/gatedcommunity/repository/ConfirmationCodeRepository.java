package projectfs44.gatedcommunity.repository;

import projectfs44.gatedcommunity.model.entity.ConfirmationCode;
import projectfs44.gatedcommunity.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmationCodeRepository extends JpaRepository<ConfirmationCode, Long> {

    Optional<ConfirmationCode> findByCode(String code);
    Optional<ConfirmationCode> findCodeByUser(User user);
}
