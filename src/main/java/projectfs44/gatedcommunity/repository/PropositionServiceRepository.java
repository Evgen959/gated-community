package projectfs44.gatedcommunity.repository;

import projectfs44.gatedcommunity.model.entity.PropositionService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropositionServiceRepository extends JpaRepository<PropositionService, Long> {

    List<PropositionService> findPropositionServiceByTitle(String title);
    List<PropositionService> findPropositionServiceByActive(boolean active);
}






