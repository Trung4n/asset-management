package asset.project.repository;

import asset.project.entity.Asset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssetRepository extends JpaRepository<Asset, UUID> {

    Optional<Asset> findByAssetCode(String assetCode);

    boolean existsByAssetCode(String assetCode);

    @Query("""
        SELECT a FROM Asset a
        LEFT JOIN FETCH a.currentDepartment
        LEFT JOIN FETCH a.createdBy
        WHERE a.id = :id
    """)
    Optional<Asset> findDetailById(@Param("id") UUID id);

    @Query("""
        SELECT a FROM Asset a
        WHERE (:keyword IS NULL OR LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%')))
        AND (:status IS NULL OR a.status = :status)
    """)
    Page<Asset> search(@Param("keyword") String keyword,
                       @Param("status") Asset.AssetStatus status,
                       Pageable pageable);
}