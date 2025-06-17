package site.currychoco.assetmanager.hrinfo.position.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.currychoco.assetmanager.hrinfo.position.domain.Position;

public interface PositionRepository extends JpaRepository<Position, String> {
}
