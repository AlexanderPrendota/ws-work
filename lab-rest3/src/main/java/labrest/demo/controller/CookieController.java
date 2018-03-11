package labrest.demo.controller;

import labrest.demo.exception.CookieNotFountException;
import labrest.demo.model.Cookie;
import labrest.demo.repositoty.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

/**
 * @author Alexander Prendota on 2/21/18 JetBrains.
 */
@RestController
public class CookieController {

    @Autowired
    private CookieRepository cookieRepository;

    @PostConstruct
    public void init() {
        Cookie cookie = new Cookie(1, "GOOD", 10, 12, "RUSSIA");
        cookieRepository.save(cookie);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getCookieById(@PathVariable long id) throws CookieNotFountException {
        Cookie кука = cookieRepository.findOne(id);
        if (кука == null) throw new CookieNotFountException("C N F");
        return ResponseEntity.ok(кука);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveCookies(@RequestBody Cookie cookie) throws CookieNotFountException {
        if (cookie == null) throw new CookieNotFountException("C N F");
        cookieRepository.save(cookie);
        return ResponseEntity.ok("Cookie was added");
    }

}
