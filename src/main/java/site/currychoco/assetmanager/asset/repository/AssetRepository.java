package site.currychoco.assetmanager.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.currychoco.assetmanager.asset.domain.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
