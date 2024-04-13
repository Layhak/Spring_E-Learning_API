package co.istad.jbsdemo.spring_elearning_api.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String flag;

    @Column(nullable = false,length = 10)
    private String iso;

    @Column(nullable = false,length = 60)
    private String name;

    @Column(name = "nice_name")
    private String niceName;

    @Column(name = "num_code",nullable = false)
    private int numberCode;

    @Column(name = "phone_code",nullable = false)
    private int phoneCode;

    @ManyToMany
    @JoinTable(
        name = "countries_cities",
        joinColumns = @JoinColumn(name = "countries_id", referencedColumnName = "id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "cities_id", referencedColumnName = "id",nullable = false)
    )
    private List<City> cities;

}
