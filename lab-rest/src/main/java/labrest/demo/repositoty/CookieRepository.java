package labrest.demo.repositoty;

import labrest.demo.model.Cookie;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Alexander Prendota on 2/21/18 JetBrains.
 */
public interface CookieRepository extends CrudRepository<Cookie, Long> {}
