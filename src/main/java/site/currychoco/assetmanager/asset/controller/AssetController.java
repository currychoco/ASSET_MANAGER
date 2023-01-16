package site.currychoco.assetmanager.asset.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import site.currychoco.assetmanager.asset.domain.Asset;
import site.currychoco.assetmanager.asset.domain.AssetCategoryNameDto;
import site.currychoco.assetmanager.asset.service.AssetService;
import site.currychoco.assetmanager.category.domain.Category;
import site.currychoco.assetmanager.category.service.CategoryService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AssetController {

    private final AssetService assetService;
    private final CategoryService categoryService;

    // ---
    // page
    // ---

    @GetMapping("/manager/asset/create")
    public String addAsset(Model model){
        List<Category> categoryDtoList = categoryService.getAllCategory();

        model.addAttribute("category", categoryDtoList);

        return "manager/asset/addAsset";
    }

    @GetMapping("manager/asset/list")
    public String getAssetList(){
        return "manager/asset/listAsset";
    }

    // ---
    // api
    // ---

    /**
     * 자산 추가
     */
    @ResponseBody
    @PostMapping("/asset")
    public void addAsset(@RequestBody Asset asset){
        assetService.addAsset(asset);
    }

    /**
     * 카테고리명 포함 현물 자산 리스트
     */
    @ResponseBody
    @GetMapping("/asset")
    public List<AssetCategoryNameDto> getAllAsset(){
        return assetService.getAllAsset();
    }
}
