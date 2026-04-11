package asset.project.repository;

import asset.project.entity.User;
import asset.project.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    List<User> findByDepartmentId(UUID departmentId);

    List<User> findByRole(UserRole role);

    boolean existsByEmail(String email);
}