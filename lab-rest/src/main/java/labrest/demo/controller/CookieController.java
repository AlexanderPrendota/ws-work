package labrest.demo.controller;

import labrest.demo.model.Cookie;
import labrest.demo.repositoty.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
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
    public void init(){
        Cookie cookie = new Cookie(1, "GOOD", 10, 12, "RUSSIA");
        cookieRepository.save(cookie);
    }

    @GetMapping("/id/{id}")
    public Cookie getCookieById(@PathVariable long id) {
        return cookieRepository.findOne(id);
    }

    @GetMapping("/cookies")
    public List<Cookie> getAllCookies() {
        final List<Cookie> cookies = new ArrayList<>();
        cookieRepository.findAll().forEach(cookies::add);
        return cookies;
    }
}
