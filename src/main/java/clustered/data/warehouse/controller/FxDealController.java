package clustered.data.warehouse.controller;
import clustered.data.warehouse.module.FxDeal;
import clustered.data.warehouse.service.FxDealService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/fx-deals")
@RequiredArgsConstructor
public class FxDealController {
    @Autowired
    private final FxDealService fxDealService;

    @PostMapping("/fx-deals")
    public ResponseEntity<FxDeal> createFxDeal(@Valid @RequestBody FxDeal fxDeal) {
        FxDeal savedFxDeal = fxDealService.saveFxDeal(fxDeal);
        return ResponseEntity.ok(savedFxDeal);
    }
    @GetMapping("/fx-deals/{uniqueId}")
    public ResponseEntity<FxDeal> getFxDealByUniqueId(@PathVariable String uniqueId) {
        FxDeal fxDeal = fxDealService.findFxDealByUniqueId(uniqueId);
        return ResponseEntity.ok(fxDeal);
    }

}





