package site.currychoco.assetmanager.category.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDto {

    private String categoryCode;
    private String categoryName;

    public static CategoryDto fromEntity(Category category){
        if(category == null){
            return null;
        }
        return new CategoryDto(
                category.getCategoryCode(),
                category.getCategoryName()
        );
    }
}
