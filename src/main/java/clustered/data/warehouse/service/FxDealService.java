package clustered.data.warehouse.service;


import clustered.data.warehouse.exceptions.handler.DuplicateFxDealException;
import clustered.data.warehouse.module.FxDeal;

public interface FxDealService {

        FxDeal saveFxDeal(FxDeal fxDeal) throws DuplicateFxDealException;
             FxDeal findFxDealByUniqueId(String uniqueId);

}


