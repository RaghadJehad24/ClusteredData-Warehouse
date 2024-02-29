package clustered.data.warehouse.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class FxDeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String uniqueId;

    @NotNull
    @Size(min = 3, max = 3)
    private String fromCurrency;

    @NotNull
    @Size(min = 3, max = 3)
    private String toCurrency;

    @NotNull
    private LocalDateTime dealTimestamp;

    @NotNull
    private BigDecimal dealAmount;
}
