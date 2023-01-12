package site.currychoco.assetmanager.asset.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import site.currychoco.assetmanager.asset.domain.Asset;
import site.currychoco.assetmanager.asset.domain.AssetCategoryNameDto;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class AssetRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public void save(Asset asset){
        sqlSessionTemplate.insert("asset.save", asset);
    }

    public List<AssetCategoryNameDto> findAll(){
        return sqlSessionTemplate.selectList("asset.findAll");
    }
}
