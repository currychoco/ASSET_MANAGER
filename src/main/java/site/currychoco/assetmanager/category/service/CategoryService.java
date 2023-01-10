package site.currychoco.assetmanager.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.currychoco.assetmanager.category.domain.Category;
import site.currychoco.assetmanager.category.domain.CategoryDto;
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
    public void createCategory(CategoryDto categoryDto){
        Category category = new Category(categoryDto);
        categoryRepository.save(category);
    }

    /**
     * 모든 카테고리 호출
     */
    public List<CategoryDto> getAllCategory(){
        List<Category> list = categoryRepository.findAll();
        List<CategoryDto> dtoList = new ArrayList<>();

        for (Category category : list){
            dtoList.add(CategoryDto.fromEntity(category));
        }

        return dtoList;
    }
}
