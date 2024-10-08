package gatedcommunity.service;

import gatedcommunity.model.entity.ConfirmationCode;
import gatedcommunity.model.entity.User;
import gatedcommunity.repository.ConfirmationCodeRepository;
import gatedcommunity.service.interfaces.ConfirmationCodeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConfirmationCodeServiceImpl implements ConfirmationCodeService {

    private final ConfirmationCodeRepository repository;

    public ConfirmationCodeServiceImpl(ConfirmationCodeRepository repository) {
        this.repository = repository;
    }

    @Override
    public String generationConfirmationCode(User user) {
        // Генерация уникально кода (использую UUID)
        String code = UUID.randomUUID().toString();

        // Создание объекта ConfirmCode и сохранение его в базу
        ConfirmationCode confirmationCode = new ConfirmationCode();
        confirmationCode.setCode(code);
        confirmationCode.setUser(user);
        confirmationCode.setExpired(LocalDateTime.now().plusDays(1)); // срок действия 1 день
//        confirmationCode.setExpired(LocalDateTime.now().plusMinutes(1)); // срок действия 1 минута

        repository.save(confirmationCode);

        //Вернуть код
        return code;
    }

    @Override
    public Optional<ConfirmationCode> findCodeByUser(User user) {
        return repository.findCodeByUser(user);
    }
    @Override
    public void remove(ConfirmationCode code) {
        repository.delete(code);
    }

    @Override
    public Optional<ConfirmationCode> findByCode(String code) {
        return repository.findByCode(code);
    }

}
