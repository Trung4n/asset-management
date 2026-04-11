package asset.project.service;

import asset.project.dto.AssetRequest;
import asset.project.entity.Asset;
import asset.project.repository.AssetRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AssetService {

    private final AssetRepository assetRepository;

    public UUID create(AssetRequest request) {
        if (assetRepository.existsByAssetCode(request.getAssetCode())) {
            throw new RuntimeException("Asset code already exists: " + request.getAssetCode());
        }

        Asset asset = Asset.builder()
                .assetCode(request.getAssetCode())
                .name(request.getName())
                .description(request.getDescription())
                .category(request.getCategory())
                .status(request.getStatus() != null ? request.getStatus() : "active")
                .purchasePrice(request.getPurchasePrice())
                .purchaseDate(request.getPurchaseDate())
                .currentDepartmentId(request.getCurrentDepartmentId())
                .createdBy(request.getCreatedBy())
                .build();

        return assetRepository.save(asset).getId();
    }

    public List<Asset> getAll(int offset, int limit) {
        return assetRepository.findAll(PageRequest.of(offset / limit, limit)).toList();
    }

    public Asset getById(UUID id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + id));
    }

    public Asset update(UUID id, AssetRequest request) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + id));

        asset.setName(request.getName());
        asset.setDescription(request.getDescription());
        asset.setCategory(request.getCategory());
        if (request.getStatus() != null) asset.setStatus(request.getStatus());
        asset.setPurchasePrice(request.getPurchasePrice());
        asset.setPurchaseDate(request.getPurchaseDate());
        asset.setCurrentDepartmentId(request.getCurrentDepartmentId());

        return assetRepository.save(asset);
    }

    public void delete(UUID id) {
        if (!assetRepository.existsById(id)) {
            throw new RuntimeException("Asset not found with id: " + id);
        }
        assetRepository.deleteById(id);
    }
}