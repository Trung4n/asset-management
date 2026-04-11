package asset.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "validation_sessions")
@Getter @Setter
public class ValidationSession {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private Short year;

    @Enumerated(EnumType.STRING)
    private ValidationSessionStatus status;

    @ManyToOne
    @JoinColumn(name = "initiated_by")
    private User initiatedBy;

    private OffsetDateTime startedAt;
    private OffsetDateTime closedAt;

    private String notes;

    @OneToMany(mappedBy = "session")
    private List<ValidationRecord> records;

    public enum ValidationSessionStatus {
        PENDING,
        IN_PROGRESS,
        CLOSED
    }
}