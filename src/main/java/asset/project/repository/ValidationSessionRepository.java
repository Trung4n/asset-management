package asset.project.repository;

import asset.project.entity.ValidationSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ValidationSessionRepository extends JpaRepository<ValidationSession, UUID> {

    Optional<ValidationSession> findByYear(Short year);

    List<ValidationSession> findByStatus(ValidationSession.ValidationSessionStatus status);
}