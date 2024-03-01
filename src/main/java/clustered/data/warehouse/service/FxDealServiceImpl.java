package clustered.data.warehouse.service;

import clustered.data.warehouse.exceptions.handler.DuplicateFxDealException;
import clustered.data.warehouse.module.FxDeal;
import clustered.data.warehouse.repository.FxDealRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * FxDealServiceImpl is the implementation of the FxDealService interface.
 * It provides methods for saving and retrieving FxDeal records.
 */
@Service
@RequiredArgsConstructor
public class FxDealServiceImpl implements FxDealService {
    private final FxDealRepository fxDealRepository;
    private static final Logger logger = LoggerFactory.getLogger(FxDealServiceImpl.class);

    /**
     * Saves a new FxDeal record.
     *
     * @param fxDeal The FxDeal object containing the details of the FxDeal to be saved.
     * @return The saved FxDeal object.
     * @throws DuplicateFxDealException if a FxDeal with the same uniqueId already exists.
     */
    @Override
    public FxDeal saveFxDeal(FxDeal fxDeal) throws DuplicateFxDealException {
        logger.info("Saving a new FxDeal with uniqueId: {}", fxDeal.getUniqueId());
        if (fxDealRepository.existsByUniqueId(fxDeal.getUniqueId())) {
            logger.error("FxDeal with uniqueId: {} already exists.", fxDeal.getUniqueId());
            throw new DuplicateFxDealException("FxDeal with uniqueId " + fxDeal.getUniqueId() + " already exists.");
        }
        return fxDealRepository.save(fxDeal);
    }

    /**
     * Retrieves an FxDeal record by its uniqueId.
     *
     * @param uniqueId The unique identifier of the FxDeal to be retrieved.
     * @return The retrieved FxDeal object.
     * @throws EntityNotFoundException if the FxDeal is not found.
     */
    @Override
    public FxDeal findFxDealByUniqueId(String uniqueId) {
        logger.info("Retrieving FxDeal with uniqueId: {}", uniqueId);
        return fxDealRepository.findByUniqueId(uniqueId)
                .orElseThrow(() -> {
                    logger.error("FxDeal with uniqueId: {} not found.", uniqueId);
                    return new EntityNotFoundException("FxDeal with uniqueId " + uniqueId + " not found.");
                });
    }
}
