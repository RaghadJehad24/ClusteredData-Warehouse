package clustered.data.warehouse.exceptions.handler;

import org.springframework.http.HttpStatus;

public class FxDealNotFoundException extends BaseException {
    public FxDealNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
