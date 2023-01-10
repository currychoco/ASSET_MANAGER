package site.currychoco.assetmanager.asset.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import site.currychoco.assetmanager.asset.domain.AssetDto;
import site.currychoco.assetmanager.asset.service.AssetService;
import site.currychoco.assetmanager.category.domain.CategoryDto;
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
        List<CategoryDto> categoryDtoList = categoryService.getAllCategory();

        model.addAttribute("category", categoryDtoList);

        return "manager/asset/addAsset";
    }

    // ---
    // api
    // ---

    @ResponseBody
    @PostMapping("/asset")
    public void addAsset(@RequestBody AssetDto assetDto){
        assetService.addAsset(assetDto);
    }
}
