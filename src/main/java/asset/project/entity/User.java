package asset.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    private String passwordHash;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private Boolean isActive;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public enum UserRole {
            admin,
            asset_manager,
            DEPARTMENT_STAFF,
            AUDITOR
        }
}
