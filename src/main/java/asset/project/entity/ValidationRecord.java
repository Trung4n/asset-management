package asset.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "validation_records")
@Getter
@Setter
public class ValidationRecord {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private ValidationSession session;

    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Enumerated(EnumType.STRING)
    private ValidationRecordStatus status;

    @ManyToOne
    @JoinColumn(name = "validated_by")
    private User validatedBy;

    private OffsetDateTime validatedAt;

    private String notes;

    public enum ValidationRecordStatus {
        VALID,
        INVALID,
        MISSING,
        PENDING
    }
}