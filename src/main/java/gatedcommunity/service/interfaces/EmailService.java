package gatedcommunity.service.interfaces;

import gatedcommunity.model.entity.User;

public interface EmailService {

    void sendConfirmationEmail(User user);
}
