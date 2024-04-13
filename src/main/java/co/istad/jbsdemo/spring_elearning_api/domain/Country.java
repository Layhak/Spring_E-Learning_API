package co.istad.jbsdemo.spring_elearning_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 250)
    private String flag;

    @Column(nullable = false, length = 10)
    private String iso;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 250)
    private String niceName;

    @Column(nullable = false)
    private Integer numCode;

    @Column(nullable = false)
    private Integer phoneCode;

}
