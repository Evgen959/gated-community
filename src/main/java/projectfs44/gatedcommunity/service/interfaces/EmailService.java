package projectfs44.gatedcommunity.service.interfaces;

import projectfs44.gatedcommunity.model.entity.User;

public interface EmailService {

    void sendConfirmationEmail(User user);
}
