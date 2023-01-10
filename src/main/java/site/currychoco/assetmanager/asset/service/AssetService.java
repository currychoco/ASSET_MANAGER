package site.currychoco.assetmanager.asset.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.currychoco.assetmanager.asset.domain.Asset;
import site.currychoco.assetmanager.asset.domain.AssetDto;
import site.currychoco.assetmanager.asset.repository.AssetRepository;

@RequiredArgsConstructor
@Service
public class AssetService {

    private final AssetRepository assetRepository;

    /**
     * 자원 생성
     */
    public void addAsset(AssetDto assetDto){
        Asset asset = new Asset(assetDto);
        assetRepository.save(asset);
    }
}
