package site.currychoco.assetmanager.category.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import site.currychoco.assetmanager.category.domain.Category;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CategoryRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    public void save(Category category){
        sqlSessionTemplate.insert("category.save", category);
    }

    public List<Category> findAll(){
        return sqlSessionTemplate.selectList("category.findAll");
    }
}
