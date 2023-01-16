package site.currychoco.assetmanager.asset.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.currychoco.assetmanager.asset.domain.Asset;
import site.currychoco.assetmanager.asset.domain.AssetCategoryNameDto;
import site.currychoco.assetmanager.asset.repository.AssetRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AssetService {

    private final AssetRepository assetRepository;

    /**
     * 자산 생성
     */
    public void addAsset(Asset asset){
        assetRepository.save(asset);
    }

    /**
     * 모든 자산 호출
     */
    public List<AssetCategoryNameDto> getAllAsset(){
        return assetRepository.findAll();
    }

    /**
     * id를 통한 자산 호출
     */
    public AssetCategoryNameDto getAssetById(Long id){
        return assetRepository.findAssetById(id);
    }

    /**
     * 자산 수정
     */
    public void updateAsset(Asset asset){
        assetRepository.update(asset);
    }

    /**
     * 자산 삭제
     */
    public void deleteAsset(Long id){
        assetRepository.delete(id);
    }

}
