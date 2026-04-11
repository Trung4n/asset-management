package asset.project.controller;

import asset.project.dto.AssetRequest;
import asset.project.entity.Asset;
import asset.project.service.AssetService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/asset")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AssetController {

    AssetService assetService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UUID createAsset(@Valid @RequestBody AssetRequest request) {
        return assetService.create(request);
    }

    @GetMapping
    List<Asset> getAssets(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit) {
        return assetService.getAll(offset, limit);
    }

    @GetMapping("/{id}")
    Asset getAsset(@PathVariable UUID id) {
        return assetService.getById(id);
    }

    @PutMapping("/{id}")
    Asset updateAsset(@PathVariable UUID id, @Valid @RequestBody AssetRequest request) {
        return assetService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAsset(@PathVariable UUID id) {
        assetService.delete(id);
    }
}