package site.currychoco.assetmanager.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.currychoco.assetmanager.category.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
