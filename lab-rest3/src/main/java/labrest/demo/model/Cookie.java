package labrest.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Alexander Prendota on 2/21/18 JetBrains.
 */
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "MESSAGES")
@NoArgsConstructor
public class Cookie {

    @Id
    @GeneratedValue
    @Column(name = "COOKIE_ID", nullable = false)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "WEIGHT")
    private Integer weight;

    @Column(name = "RADIUS")
    private Integer radius;

    @Column(name = "COUNTRY")
    private String country;
}
