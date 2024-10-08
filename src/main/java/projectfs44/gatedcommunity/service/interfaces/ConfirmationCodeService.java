package projectfs44.gatedcommunity.service.interfaces;

import projectfs44.gatedcommunity.model.entity.ConfirmationCode;
import projectfs44.gatedcommunity.model.entity.User;

import java.util.Optional;

public interface ConfirmationCodeService {
    String generationConfirmationCode(User user);

    Optional<ConfirmationCode> findCodeByUser(User user);

    void remove(ConfirmationCode code);

    Optional<ConfirmationCode> findByCode(String code);
}
