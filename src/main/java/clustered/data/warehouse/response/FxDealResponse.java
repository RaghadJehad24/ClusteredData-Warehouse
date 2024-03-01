package clustered.data.warehouse.response;

import clustered.data.warehouse.module.FxDeal;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class FxDealResponse {
    private String message;
    private Long id;
    private String uniqueId;
    private String fromCurrency;
    private String toCurrency;
    private LocalDateTime dealTimestamp;
    private BigDecimal dealAmount;

    public FxDealResponse(String message, FxDeal fxDeal) {
        this.message = message;
        this.id = fxDeal.getId();
        this.uniqueId = fxDeal.getUniqueId();
        this.fromCurrency = fxDeal.getFromCurrency();
        this.toCurrency = fxDeal.getToCurrency();
        this.dealAmount = fxDeal.getDealAmount();
        this.dealTimestamp = fxDeal.getDealTimestamp();
    }


}

