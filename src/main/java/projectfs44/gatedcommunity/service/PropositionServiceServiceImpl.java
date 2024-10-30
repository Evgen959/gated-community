package projectfs44.gatedcommunity.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import projectfs44.gatedcommunity.exception_handling.exceptions.TextException;
import projectfs44.gatedcommunity.model.dto.PropositionServiceDTO;
import projectfs44.gatedcommunity.model.entity.PropositionService;
import projectfs44.gatedcommunity.model.entity.PropositionServiceFile;
import projectfs44.gatedcommunity.repository.PropositionServiceRepository;
import projectfs44.gatedcommunity.service.interfaces.PropositionServiceService;
import projectfs44.gatedcommunity.service.mapping.PropositionServiceMappingService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropositionServiceServiceImpl implements PropositionServiceService {

    private final PropositionServiceRepository repository;
    private final PropositionServiceMappingService mapper;

    public PropositionServiceServiceImpl(PropositionServiceRepository repository, PropositionServiceMappingService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PropositionServiceDTO savePropositionService(PropositionServiceDTO propositionServiceDTO, List<MultipartFile> files) {
        if (propositionServiceDTO == null) {
            throw new IllegalArgumentException("PropositionServiceDTO cannot be null");
        }
        PropositionService propositionService = mapper.mapDtoToEntity(propositionServiceDTO);
        propositionService.setActive(true);

        if (files != null) {
            List<PropositionServiceFile> propositionServiceFiles = new ArrayList<>(); // Список для файлов

            for (MultipartFile file : files) {
                try {
                    byte[] fileData = file.getBytes(); // Получаем данные файла как byte[]
                    PropositionServiceFile propositionServiceFile = new PropositionServiceFile();
                    propositionServiceFile.setFileData(fileData); // Устанавливаем данные файла
                    propositionServiceFile.setPropositionService(propositionService); // Устанавливаем связь с услугой

                    propositionServiceFiles.add(propositionServiceFile);
                    System.out.println("Получен файл: " + file.getOriginalFilename() + ", Тип содержимого: " + file.getContentType());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            propositionService.setFiles(propositionServiceFiles); // Устанавливаем файлы в сущность услуги
        } else {
            System.out.println("Файлы не были получены");
        }

        try {
            PropositionService savedService = repository.save(propositionService); // Сохраняем услугу и связанные файлы
            return mapper.mapEntityToDto(savedService); // Возвращаем DTO сохраненной сущности
        } catch (Exception e) {
            throw new RuntimeException("Failed to save PropositionService", e);
        }
    }


    @Override
    public PropositionServiceDTO getPropositionServiceById(long id) {
        PropositionService propositionService = repository.findById(id).orElse(null);

        if (propositionService == null) {
            throw new TextException("Proposition service with id" + id + " not found");
        }
        if (!propositionService.isActive()) {
            throw new TextException("Proposition service not activity");
        }

        return mapper.mapEntityToDto(propositionService);
    }

    @Override
    public List<PropositionServiceDTO> getPropositionServiceByTitle(String title) {
        return repository.findPropositionServiceByTitle(title).stream()
                .filter(PropositionService::isActive)
                .map(mapper::mapEntityToDto)
                .toList();
    }

    @Transactional
    @Override
    public List<PropositionServiceDTO> getAllPropositionService() {
        return repository.findAll().stream()
                .filter(PropositionService::isActive)
                .map(mapper::mapEntityToDto)
                .collect(Collectors.toList());
    }
//    @Override
//    public List<PropositionServiceDTO> getAllPropositionService() {
//        return repository.findAll().stream()
//                // фильтруем
//                .filter(PropositionService::isActive)
//                // превращаем элемент стрима из Product в стрим ProductDTO
//                .map(mapper::mapEntityToDto)
//                // собираем обратно в список
//                .toList();
//    }

    @Override
    public PropositionServiceDTO updatePropositionService(Long id, PropositionServiceDTO propositionServiceDTO) {
        PropositionService propositionService = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proposition service not found for id: " + id));

        mapper.mapDTOToEntityUpdate(propositionServiceDTO, propositionService);  // Use mapper for update Entity

        propositionService.setActive(true);

        return mapper.mapEntityToDto(repository.save(propositionService));
    }

    @Override
    public PropositionServiceDTO deletePropositionServiceById(Long id) {
        PropositionService propositionService = repository.findById(id).orElse(null);
        if (propositionService != null) {
            repository.deleteById(id);
        }
        return mapper.mapEntityToDto(propositionService);

    }

    @Override
    public PropositionServiceDTO restorePropositionServiceById(Long id) {
        PropositionService propositionService = repository.findById(id).orElse(null);
        if (propositionService != null) {
            propositionService.setActive(true);
            return mapper.mapEntityToDto(propositionService);
        } else {
            throw new TextException("");
        }

    }

    @Override
    public PropositionServiceDTO removePropositionServiceById(Long id) {
        PropositionService propositionService = repository.findById(id).orElse(null);
        if (propositionService != null) {
            propositionService.setActive(false);
        }
        return mapper.mapEntityToDto(propositionService);
    }
}
