package asset.project.dto.auth;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginResponse {

    private String token;

    private UUID userId;

    private String email;

    private String role;

    private String fullName;

    private UUID departmentId;
}