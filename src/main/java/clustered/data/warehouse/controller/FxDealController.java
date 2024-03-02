package clustered.data.warehouse.controller;

import clustered.data.warehouse.module.FxDeal;
import clustered.data.warehouse.response.FxDealResponse;
import clustered.data.warehouse.service.FxDealService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * FxDealController is responsible for handling HTTP requests related to FxDeal operations.
 * It provides endpoints for creating and retrieving FxDeal records.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FxDealController {
    private static final Logger logger = LoggerFactory.getLogger(FxDealController.class);
    private final FxDealService fxDealService;

    /**
     * Creates a new FxDeal record.
     *
     * @param fxDeal The FxDeal object containing the details of the FxDeal to be created.
     * @return A ResponseEntity containing the FxDealResponse object with the created FxDeal's details.
     */
    @PostMapping("/fx-deals")
    public ResponseEntity<FxDealResponse> createFxDeal(@Valid @RequestBody FxDeal fxDeal) {
        logger.info("Creating a new FxDeal with uniqueId: {}", fxDeal.getUniqueId());
        FxDeal savedFxDeal = fxDealService.saveFxDeal(fxDeal);
        FxDealResponse response = new FxDealResponse("FxDeal created successfully", savedFxDeal);
        logger.info("FxDeal created successfully with uniqueId: {}", savedFxDeal.getUniqueId());
        return ResponseEntity.ok(response);
    }

    /**
     * Retrieves an FxDeal record by its uniqueId.
     *
     * @param uniqueId The unique identifier of the FxDeal to be retrieved.
     * @return A ResponseEntity containing the FxDealResponse object with the retrieved FxDeal's details.
     */
    @GetMapping("/fx-deals/{uniqueId}")
    public ResponseEntity<FxDealResponse> getFxDealByUniqueId(@PathVariable String uniqueId) {
        logger.info("Retrieving FxDeal with uniqueId: {}", uniqueId);
        FxDeal fxDeal = fxDealService.findFxDealByUniqueId(uniqueId);
        if (fxDeal == null) {
            logger.warn("FxDeal with uniqueId: {} not found.", uniqueId);
            return ResponseEntity.notFound().build();
        }
        FxDealResponse response = new FxDealResponse("FxDeal retrieved successfully", fxDeal);
        logger.info("FxDeal retrieved successfully with uniqueId: {}", fxDeal.getUniqueId());
        return ResponseEntity.ok(response);
    }
}
