package asset.project.repository;

import asset.project.entity.ValidationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ValidationRecordRepository extends JpaRepository<ValidationRecord, UUID> {

    List<ValidationRecord> findBySessionId(UUID sessionId);

    List<ValidationRecord> findByAssetId(UUID assetId);

    Optional<ValidationRecord> findBySessionIdAndAssetId(UUID sessionId, UUID assetId);

    List<ValidationRecord> findByStatus(ValidationRecord.ValidationRecordStatus status);
}