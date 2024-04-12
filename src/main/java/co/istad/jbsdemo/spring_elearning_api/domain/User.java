package co.istad.jbsdemo.spring_elearning_api.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String address1;

    @Column()
    private String address2;

    @Column(name = "dob")
    private LocalDate dob;

    @Column()
    private String email;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "gender",length = 30)
    private String gender;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "is_verified")
    private Boolean isVerified;

    @Column(name = "national_id_card")
    private String nationalIdCard;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "profile")
    private String profile;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> role;

    @Column(name = "username")
    private String username;

//Generate UUID column
    @Column(name = "uuid", unique = true, nullable = false, length = 36)
    private String uuid;

    //verified code
    @Column(name = "verified_code",length = 100)
    private String verifiedCode;

    //city id
    @Column(name = "city_id")
    private Long cityId;

    //province id
    @Column(name = "country_id")
    private Long countryId;
}
