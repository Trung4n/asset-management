package asset.project.dto;

import jakarta.validation.constraints.Size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserLoginRequest {

    String Mail;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;
}