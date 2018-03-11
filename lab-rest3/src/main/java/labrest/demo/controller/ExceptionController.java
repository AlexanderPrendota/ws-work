package labrest.demo.controller;

import labrest.demo.exception.CookieNotFountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Alexander Prendota on 3/11/18 JetBrains.
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = CookieNotFountException.class)
    public ModelAndView
    cookieExceptionHandler() {
        return new ModelAndView("exc").addObject("no cookies");
    }
}
