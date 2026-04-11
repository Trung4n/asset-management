//package asset.project.service;
//
//import asset.project.entity.Asset;
//import asset.project.repository.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class AssetService {
//
//    private final AssetRepository assetRepository;
//    private final DepartmentRepository departmentRepository;
//    private final UserRepository userRepository;
//    private final AssetAssignmentRepository assignmentRepository;
//    private final AuditLogRepository auditLogRepository;
//
//    // ================= CREATE =================
//    public Asset createAsset(Asset asset, UUID createdById) {
//
//        if (assetRepository.existsByAssetCode(asset.getAssetCode())) {
//            throw new RuntimeException("Asset code already exists");
//        }
//
//        if (asset.getCurrentDepartment() != null) {
//            UUID deptId = asset.getCurrentDepartment().getId();
//            Department dept = departmentRepository.findById(deptId)
//                    .orElseThrow(() -> new RuntimeException("Department not found"));
//            asset.setCurrentDepartment(dept);
//        }
//
//        User createdBy = userRepository.findById(createdById)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        asset.setCreatedBy(createdBy);
//        asset.setStatus(AssetStatus.ACTIVE);
//        asset.setCreatedAt(OffsetDateTime.now());
//        asset.setUpdatedAt(OffsetDateTime.now());
//
//        Asset saved = assetRepository.save(asset);
//
//        logAudit(AuditAction.ASSET_CREATED, createdBy, saved);
//
//        return saved;
//    }
//
//    // ================= UPDATE =================
//    public Asset updateAsset(UUID id, Asset updatedData, UUID userId) {
//
//        Asset asset = assetRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Asset not found"));
//
//        asset.setName(updatedData.getName());
//        asset.setDescription(updatedData.getDescription());
//        asset.setCategory(updatedData.getCategory());
//        asset.setPurchasePrice(updatedData.getPurchasePrice());
//        asset.setPurchaseDate(updatedData.getPurchaseDate());
//        asset.setUpdatedAt(OffsetDateTime.now());
//
//        Asset saved = assetRepository.save(asset);
//
//        User user = userRepository.findById(userId).orElse(null);
//        logAudit(AuditAction.ASSET_UPDATED, user, saved);
//
//        return saved;
//    }
//
//    // ================= GET DETAIL =================
//    @Transactional(readOnly = true)
//    public Asset getDetail(UUID id) {
//        return assetRepository.findDetailById(id)
//                .orElseThrow(() -> new RuntimeException("Asset not found"));
//    }
//
//    // ================= SEARCH =================
//    @Transactional(readOnly = true)
//    public Page<Asset> search(String keyword, AssetStatus status, Pageable pageable) {
//        return assetRepository.search(keyword, status, pageable);
//    }
//
//    // ================= DELETE =================
//    public void deleteAsset(UUID id, UUID userId) {
//
//        Asset asset = assetRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Asset not found"));
//
//        assetRepository.delete(asset);
//
//        User user = userRepository.findById(userId).orElse(null);
//        logAudit(AuditAction.ASSET_DELETED, user, asset);
//    }
//
//    // ================= ARCHIVE =================
//    public void archiveAsset(UUID id, UUID userId) {
//
//        Asset asset = assetRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Asset not found"));
//
//        asset.setStatus(AssetStatus.ARCHIVED);
//        asset.setArchivedAt(OffsetDateTime.now());
//
//        assetRepository.save(asset);
//
//        User user = userRepository.findById(userId).orElse(null);
//        logAudit(AuditAction.ASSET_ARCHIVED, user, asset);
//    }
//
//    // ================= TRANSFER =================
//    public void transferAsset(UUID assetId, UUID toDepartmentId, UUID userId) {
//
//        Asset asset = assetRepository.findById(assetId)
//                .orElseThrow(() -> new RuntimeException("Asset not found"));
//
//        Department newDept = departmentRepository.findById(toDepartmentId)
//                .orElseThrow(() -> new RuntimeException("Department not found"));
//
//        // close old assignment
//        assignmentRepository.findActiveByAssetId(assetId)
//                .ifPresent(a -> {
//                    a.setReturnedAt(OffsetDateTime.now());
//                    assignmentRepository.save(a);
//                });
//
//        // create new assignment
//        AssetAssignment assignment = new AssetAssignment();
//        assignment.setAsset(asset);
//        assignment.setDepartment(newDept);
//        assignment.setAssignedAt(OffsetDateTime.now());
//
//        User user = userRepository.findById(userId).orElse(null);
//        assignment.setAssignedBy(user);
//
//        assignmentRepository.save(assignment);
//
//        // update asset
//        asset.setCurrentDepartment(newDept);
//        asset.setUpdatedAt(OffsetDateTime.now());
//        assetRepository.save(asset);
//
//        logAudit(AuditAction.ASSET_TRANSFERRED, user, asset);
//    }
//
//    // ================= AUDIT =================
//    private void logAudit(AuditAction action, User user, Asset asset) {
//
//        AuditLog log = new AuditLog();
//        log.setAction(action);
//        log.setPerformedBy(user);
//        log.setAsset(asset);
//        log.setCreatedAt(OffsetDateTime.now());
//
//        auditLogRepository.save(log);
//    }
//}