package site.currychoco.assetmanager.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.currychoco.assetmanager.category.domain.Category;
import site.currychoco.assetmanager.category.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * 카테고리 생성
     */
    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    /**
     * 모든 카테고리 호출
     */
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
