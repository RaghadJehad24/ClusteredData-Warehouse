package clustered.data.warehouse.exceptions.handler;


import org.springframework.http.HttpStatus;

public class DuplicateFxDealException extends BaseException {
    public DuplicateFxDealException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
