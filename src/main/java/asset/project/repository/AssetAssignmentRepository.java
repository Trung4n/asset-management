package asset.project.repository;

import asset.project.entity.AssetAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AssetAssignmentRepository extends JpaRepository<AssetAssignment, UUID> {

    List<AssetAssignment> findByAssetId(UUID assetId);

    List<AssetAssignment> findByDepartmentId(UUID departmentId);

    @Query("SELECT aa FROM AssetAssignment aa WHERE aa.returnedAt IS NULL")
    List<AssetAssignment> findActiveAssignments();
}