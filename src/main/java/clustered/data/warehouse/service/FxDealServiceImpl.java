package clustered.data.warehouse.service;


import clustered.data.warehouse.exceptions.handler.DuplicateFxDealException;
import clustered.data.warehouse.module.FxDeal;
import clustered.data.warehouse.repository.FxDealRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FxDealServiceImpl implements FxDealService {
    @Autowired
    private final FxDealRepository fxDealRepository;


    @Override
    public FxDeal saveFxDeal(FxDeal fxDeal)  throws DuplicateFxDealException{
            if (fxDealRepository.existsByUniqueId(fxDeal.getUniqueId())) {
                throw new DuplicateFxDealException("FxDeal with uniqueId " + fxDeal.getUniqueId() + " already exists.");
            }
            return fxDealRepository.save(fxDeal);
        }

    @Override
    public FxDeal findFxDealByUniqueId(String uniqueId) {
        return fxDealRepository.findByUniqueId(uniqueId)
                .orElseThrow(() -> new EntityNotFoundException("FxDeal with uniqueId " + uniqueId + " not found."));

    }

}
