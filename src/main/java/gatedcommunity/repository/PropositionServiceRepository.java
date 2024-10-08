package gatedcommunity.repository;

import gatedcommunity.model.entity.PropositionService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropositionServiceRepository extends JpaRepository<PropositionService, Long> {

    List<PropositionService> findPropositionServiceByTitle(String title);
//    Optional<PropositionService> findPropositionServiceByTitle(String title);
}






