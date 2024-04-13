package co.istad.jbsdemo.spring_elearning_api.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String address1;

    @Column
    private String address2;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(name = "family_name",nullable = false)
    private String familyName;

    @Column(name = "gender", length = 30,nullable = false)
    private String gender;

    @Column(name = "given_name",nullable = false)
    private String givenName;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "is_verified")
    private Boolean isVerified;

    @Column(name = "national_id_card",nullable = false)
    private String nationalIdCard;

    @Column(name = "password",nullable = false,length = 30)
    private String password;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "profile")
    private String profile;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id",nullable = false))
    private List<Role> role;

    @Column(name = "username",nullable = false,unique = true)
    private String username;

    //Generate UUID column
    @Column(name = "uuid", unique = true, nullable = false)
    private String uuid;

    //verified code
    @Column(name = "verified_code", length = 100)
    private String verifiedCode;

    //city id
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
