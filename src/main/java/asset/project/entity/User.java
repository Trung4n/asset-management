package asset.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false, unique = true)
    private UUID id;

    @Email
    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password_hash;

    @Column(nullable = false)
    private String role;
}