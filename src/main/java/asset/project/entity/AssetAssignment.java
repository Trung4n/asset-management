package asset.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "asset_assignments")
@Getter @Setter
public class AssetAssignment {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "assigned_by")
    private User assignedBy;

    private OffsetDateTime assignedAt;
    private OffsetDateTime returnedAt;

    private String notes;
}