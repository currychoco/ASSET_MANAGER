package site.currychoco.assetmanager.asset.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import site.currychoco.assetmanager.asset.domain.Asset;
import site.currychoco.assetmanager.asset.domain.AssetCategoryNameDto;
import site.currychoco.assetmanager.asset.domain.AssetExcelOutputDto;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class AssetRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public void save(Asset asset){
        sqlSessionTemplate.insert("asset.save", asset);
    }

    public List<AssetCategoryNameDto> findRentedAllByEmpNo(Long empNo){
        return sqlSessionTemplate.selectList("asset.findRentedAllByEmpNo", empNo);
    }

    public List<AssetCategoryNameDto> findAll(){
        return sqlSessionTemplate.selectList("asset.findAll");
    }

    public AssetCategoryNameDto findAssetById(Long id){
        return sqlSessionTemplate.selectOne("asset.findById", id);
    }

    public void update(Asset asset){
        sqlSessionTemplate.update("asset.update", asset);
    }

    public void delete(Long id){
        sqlSessionTemplate.delete("asset.delete", id);
    }

    public List<AssetExcelOutputDto> findAllForExcel() { return sqlSessionTemplate.selectList("asset.findAllForExcel"); }
}
