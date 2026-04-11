package asset.project.repository;

import asset.project.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, UUID> {

    List<AuditLog> findByAction(AuditLog.AuditAction action);

    List<AuditLog> findByAssetId(UUID assetId);

    List<AuditLog> findByPerformedById(UUID userId);

    @Query("SELECT a FROM AuditLog a ORDER BY a.createdAt DESC")
    List<AuditLog> findLatestLogs(Pageable pageable);
}