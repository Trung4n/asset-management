package asset.project.repository;

import asset.project.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssetRepository extends JpaRepository<Asset, UUID> {

    Optional<Asset> findByAssetCode(String assetCode);

    List<Asset> findByStatus(Asset.AssetStatus status);

    List<Asset> findByCategory(Asset.AssetCategory category);

    List<Asset> findByCurrentDepartmentId(UUID departmentId);

    boolean existsByAssetCode(String assetCode);

    @Query("SELECT a FROM Asset a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Asset> searchByName(@Param("keyword") String keyword);
}