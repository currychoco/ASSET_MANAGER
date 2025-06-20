package site.currychoco.assetmanager.asset.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import site.currychoco.assetmanager.asset.domain.Asset;
import site.currychoco.assetmanager.asset.domain.AssetCategoryNameDto;
import site.currychoco.assetmanager.asset.domain.AssetExcelOutputDto;
import site.currychoco.assetmanager.asset.repository.AssetRepository;
import site.currychoco.assetmanager.util.excel.ExcelUtils;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AssetService {

    private final AssetRepository assetRepository;

    /**
     * 자산 생성
     */
    @Transactional
    public void addAsset(Asset asset){
        assetRepository.save(asset);
    }

    /**
     * 내 자산 조회
     */
    public List<AssetCategoryNameDto> getMyAssets(Long empNo){
        return assetRepository.findRentedAllByEmpNo(empNo);
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
    @Transactional
    public void updateAsset(Asset asset){
        assetRepository.update(asset);
    }

    /**
     * 자산 삭제
     */
    @Transactional
    public void deleteAsset(Long id){
        assetRepository.delete(id);
    }

    /**
     * 엑셀 추출용 자산 리스트
     */
    public List<AssetExcelOutputDto> getAllAssetForExcel(){
        return assetRepository.findAllForExcel();
    }

    @Transactional
    public void addAssetsByExcel(MultipartFile mf) {
        ExcelUtils.parseAssetExcelInput(mf).forEach(this::addAsset);
    }
}
