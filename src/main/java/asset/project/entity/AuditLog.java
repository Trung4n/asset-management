package asset.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "audit_logs")
@Getter @Setter
public class AuditLog {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    private AuditAction action;

    @ManyToOne
    @JoinColumn(name = "performed_by")
    private User performedBy;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "target_user_id")
    private User targetUser;

    @Column(columnDefinition = "jsonb")
    private String beforeState;

    @Column(columnDefinition = "jsonb")
    private String afterState;

    private String ipAddress;

    private OffsetDateTime createdAt;

    public enum AuditAction {
        ASSET_CREATED,
        ASSET_UPDATED,
        ASSET_ARCHIVED,
        ASSET_DELETED,
        ASSET_ASSIGNED,
        ASSET_TRANSFERRED,
        VALIDATION_INITIATED,
        VALIDATION_RECORD_UPDATED,
        ROLE_ASSIGNED,
        ROLE_REVOKED,
        USER_CREATED,
        USER_DEACTIVATED
    }
}