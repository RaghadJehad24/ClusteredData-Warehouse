package clustered.data.warehouse;

import clustered.data.warehouse.controller.FxDealController;
import clustered.data.warehouse.module.FxDeal;
import clustered.data.warehouse.response.FxDealResponse;
import clustered.data.warehouse.service.FxDealService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FxDealControllerTest {

    @Mock
    private FxDealService fxDealService;

    @InjectMocks
    private FxDealController fxDealController;

    private FxDeal fxDeal;

    @BeforeEach
    public void setUp() {
        fxDeal = new FxDeal();
        fxDeal.setUniqueId("123");
        fxDeal.setFromCurrency("USD");
        fxDeal.setToCurrency("EUR");
        fxDeal.setDealTimestamp(LocalDateTime.now());
        fxDeal.setDealAmount(BigDecimal.valueOf(1000));
    }

    @Test
    public void testCreateFxDeal_Success() {
        when(fxDealService.saveFxDeal(any(FxDeal.class))).thenReturn(fxDeal);

        ResponseEntity<FxDealResponse> response = fxDealController.createFxDeal(fxDeal);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("FxDeal created successfully", response.getBody().getMessage());
        verify(fxDealService, times(1)).saveFxDeal(any(FxDeal.class));
    }

    @Test
    public void testGetFxDealByUniqueId_Exists() {
        when(fxDealService.findFxDealByUniqueId(anyString())).thenReturn(fxDeal);

        ResponseEntity<FxDealResponse> response = fxDealController.getFxDealByUniqueId(fxDeal.getUniqueId());

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("FxDeal retrieved successfully", response.getBody().getMessage());
        verify(fxDealService, times(1)).findFxDealByUniqueId(anyString());
    }

    @Test
    public void testGetFxDealByUniqueId_NotExists() {
        when(fxDealService.findFxDealByUniqueId(anyString())).thenReturn(null);

        ResponseEntity<FxDealResponse> response = fxDealController.getFxDealByUniqueId(fxDeal.getUniqueId());

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        verify(fxDealService, times(1)).findFxDealByUniqueId(anyString());
    }
}
