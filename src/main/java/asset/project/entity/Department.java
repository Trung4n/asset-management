package asset.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "departments")
@Getter @Setter
public class Department {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(unique = true)
    private String code;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "department")
    private List<User> users;

    @OneToMany(mappedBy = "currentDepartment")
    private List<Asset> assets;
}