package gatedcommunity.service.interfaces;

import gatedcommunity.model.entity.ConfirmationCode;
import gatedcommunity.model.entity.User;

import java.util.Optional;

public interface ConfirmationCodeService {
    String generationConfirmationCode(User user);

    Optional<ConfirmationCode> findCodeByUser(User user);

    void remove(ConfirmationCode code);

    Optional<ConfirmationCode> findByCode(String code);
}
