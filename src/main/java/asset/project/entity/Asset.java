package asset.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "assets")
@Getter @Setter
public class Asset {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String assetCode;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private AssetCategory category;

    @Enumerated(EnumType.STRING)
    private AssetStatus status;

    private BigDecimal purchasePrice;
    private LocalDate purchaseDate;

    @ManyToOne
    @JoinColumn(name = "current_department_id")
    private Department currentDepartment;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private OffsetDateTime archivedAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "asset")
    private List<AssetAssignment> assignments;

    public enum AssetCategory {
        ELECTRONICS,
        FURNITURE,
        VEHICLE,
        EQUIPMENT,
        SOFTWARE,
        OTHER
    }

    public enum AssetStatus {
        ACTIVE,
        INACTIVE,
        ARCHIVED,
        DISPOSED
    }
}