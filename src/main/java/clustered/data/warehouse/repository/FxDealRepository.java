package clustered.data.warehouse.repository;

import clustered.data.warehouse.module.FxDeal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FxDealRepository extends JpaRepository<FxDeal, Long> {
    boolean existsByUniqueId(String uniqueId);

    Optional<FxDeal> findByUniqueId(String uniqueId);

}
