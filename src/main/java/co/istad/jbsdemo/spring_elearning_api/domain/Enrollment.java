package co.istad.jbsdemo.spring_elearning_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 250)
    private String code;

    private LocalDate certifiedAt;

    @Column(nullable = false)
    private LocalDate enrolledAt;

    private Boolean isCertified;

    private Boolean isDeleted;

    private Integer progress;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
