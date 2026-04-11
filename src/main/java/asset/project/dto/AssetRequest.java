package asset.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssetRequest {

    @NotBlank(message = "Asset code is required")
    String assetCode;

    @NotBlank(message = "Name is required")
    String name;

    String description;

    @NotBlank(message = "Category is required")
    String category;

    String status;

    BigDecimal purchasePrice;

    LocalDate purchaseDate;

    UUID currentDepartmentId;

    UUID createdBy;
}