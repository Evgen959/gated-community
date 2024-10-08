package gatedcommunity.service;

import gatedcommunity.exception_handling.exceptions.TextException;
import gatedcommunity.model.dto.PropositionServiceDTO;
import gatedcommunity.model.entity.PropositionService;
import gatedcommunity.repository.PropositionServiceRepository;
import gatedcommunity.service.interfaces.PropositionServiceService;
import gatedcommunity.service.mapping.PropositionServiceMappingService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropositionServiceServiceImpl implements PropositionServiceService {

    private final PropositionServiceRepository repository;
    private final PropositionServiceMappingService mapper;

    public PropositionServiceServiceImpl(PropositionServiceRepository repository, PropositionServiceMappingService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public void attachImage(String imageUrl, String PropositionServiceTitle) {

    }

    @Override
    public PropositionServiceDTO savePropositionService(PropositionServiceDTO propositionServiceDTO) {
        PropositionService propositionService = mapper.mapDtoToEntity(propositionServiceDTO);
        propositionService.setActive(true);
        return mapper.mapEntityToDto(repository.save(propositionService));
    }

    @Override
    public PropositionServiceDTO getPropositionServiceById(long id) {
        PropositionService propositionService = repository.findById(id).orElse(null);

        if (propositionService == null ){
            throw  new TextException("Proposition service with id" + id + " not found");
        }
        if (!propositionService.isActive()){
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

    @Override
    public List<PropositionServiceDTO> getAllPropositionService() {
        return repository.findAll().stream()
                // фильтруем
                .filter(PropositionService::isActive)
                // превращаем элемент стрима из Product в стрим ProductDTO
                .map(mapper::mapEntityToDto)
                // собираем обратно в список
                .toList();
    }

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
