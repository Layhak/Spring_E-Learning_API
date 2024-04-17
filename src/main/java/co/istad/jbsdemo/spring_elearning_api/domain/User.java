package co.istad.jbsdemo.spring_elearning_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250)
    private String address1;

    @Column(length = 250)
    private String address2;

    private LocalDate dob;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(length = 100)
    private String familyName;

    @Column(nullable = false, length = 10)
    private String gender;

    @Column(length = 50)
    private String givenName;

    private Boolean isDeleted;

    private Boolean isVerified;

    @Column(unique = true, nullable = false, length = 250)
    private String nationalIdCard;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column(length = 250)
    private String profile;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(unique = true, nullable = false, length = 250)
    private String uuid;

    @Column(length = 100)
    private String verifiedCode;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Instructor> instructors;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;


}
