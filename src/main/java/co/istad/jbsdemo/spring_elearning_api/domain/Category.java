package co.istad.jbsdemo.spring_elearning_api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String alias;

    private String icons;

    @ColumnDefault("false")
    private Boolean isDeleted;

    @ColumnDefault("false")
    private Boolean isDisabled;

    @Column(unique = true, nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;
}
