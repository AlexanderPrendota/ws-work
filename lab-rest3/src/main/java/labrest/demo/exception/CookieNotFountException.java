package labrest.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Alexander Prendota on 3/11/18 JetBrains.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cookie is not found")
public class CookieNotFountException extends Exception {
    public CookieNotFountException(String message) {
        super(message);
    }
}
