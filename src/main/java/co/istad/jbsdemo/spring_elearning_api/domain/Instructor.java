package co.istad.jbsdemo.spring_elearning_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String biography;

    @Column(length = 250)
    private String github;

    @Column(length = 250)
    private String jobTitle;

    @Column(length = 250)
    private String linkedIn;

    @Column(length = 250)
    private String website;

    private Boolean isBlocked;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
