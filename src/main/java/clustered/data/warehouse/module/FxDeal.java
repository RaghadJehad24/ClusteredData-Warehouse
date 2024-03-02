package clustered.data.warehouse.module;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "fx_deal")
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
