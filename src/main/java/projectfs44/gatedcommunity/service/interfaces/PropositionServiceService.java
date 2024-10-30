package projectfs44.gatedcommunity.service.interfaces;

import org.springframework.web.multipart.MultipartFile;
import projectfs44.gatedcommunity.model.dto.PropositionServiceDTO;

import java.util.List;

public interface PropositionServiceService {

    PropositionServiceDTO savePropositionService(PropositionServiceDTO propositionServiceDTO, List<MultipartFile> files);

    PropositionServiceDTO getPropositionServiceById(long id);

    List<PropositionServiceDTO> getPropositionServiceByTitle(String title);

    List<PropositionServiceDTO> getAllPropositionService();

    PropositionServiceDTO updatePropositionService(Long id, PropositionServiceDTO propositionServiceDTO);

    PropositionServiceDTO deletePropositionServiceById(Long id);

    PropositionServiceDTO restorePropositionServiceById(Long id);

    PropositionServiceDTO removePropositionServiceById(Long id);


}
