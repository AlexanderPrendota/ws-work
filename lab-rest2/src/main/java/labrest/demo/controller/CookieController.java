package labrest.demo.controller;

import labrest.demo.model.Cookie;
import labrest.demo.repositoty.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/cookiess")
    public List<Cookie> getAllCookies() {
        final List<Cookie> cookies = new ArrayList<>();
        cookieRepository.findAll().forEach(cookies::add);
        return cookies;
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveCookies(@RequestBody Cookie cookie) {
        if (cookie != null) {
            cookieRepository.save(cookie);
            return ResponseEntity.ok("Cookie was added");
        }
        return new ResponseEntity<>("Bad-bad :(", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCookies(@RequestBody Cookie cookie) {
        if (cookie != null) {
            Cookie кука = cookieRepository.findOne(cookie.getId());
            if (кука != null) {
                кука.setCountry(cookie.getCountry());
                кука.setName(cookie.getName());
                кука.setRadius(cookie.getRadius());
                кука.setWeight(cookie.getWeight());
                cookieRepository.save(кука);
                return ResponseEntity.ok("Cookie was update");
            }
            return new ResponseEntity<>("NO COOKIE :(", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Bad-bad :(", HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCookie(@PathVariable long id) {
        cookieRepository.delete(id);
        return ResponseEntity.ok("Cookie: " + id + " was deleted");
    }

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

}
