package site.currychoco.assetmanager.position.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.currychoco.assetmanager.position.domain.Position;

public interface PositionRepository extends JpaRepository<Position, String> {
}
