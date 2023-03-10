package site.currychoco.assetmanager.asset.controller;

import lombok.RequiredArgsConstructor;
import org.apache.poi.util.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import site.currychoco.assetmanager.asset.domain.*;
import site.currychoco.assetmanager.asset.service.AssetService;
import site.currychoco.assetmanager.category.domain.Category;
import site.currychoco.assetmanager.category.service.CategoryService;
import site.currychoco.assetmanager.util.excel.ExcelUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping("/manager/asset/upload")
    public String addAssetByFile(){
        return "manager/asset/uploadAsset";
    }

    @GetMapping("manager/asset/list")
    public String getAssetList(){
        return "manager/asset/listAsset";
    }

    @GetMapping("manager/asset/detail")
    public String getAssetDetail(@RequestParam(name = "id")Long id, Model model){
        AssetCategoryNameDto asset = assetService.getAssetById(id);
        List<Category> category = categoryService.getAllCategory();
        List<AssetStateDto> stateList = Arrays.asList(AssetState.values()).stream().map(n -> n.toDto()).collect(Collectors.toList());

        model.addAttribute("asset", asset);
        model.addAttribute("category", category);
        model.addAttribute("assetState", stateList);

        return "manager/asset/detailAsset";
    }

    // ---
    // api
    // ---

    /**
     * ?????? ??????
     */
    @ResponseBody
    @PostMapping("/asset")
    public void addAsset(@RequestBody Asset asset){
        assetService.addAsset(asset);
    }

    /**
     * ??????????????? ?????? ?????? ?????? ?????????
     */
    @ResponseBody
    @GetMapping("/asset")
    public List<AssetCategoryNameDto> getAllAsset(){
        return assetService.getAllAsset();
    }

    /**
     * ?????? ?????? ?????????
     */
    @ResponseBody
    @GetMapping("/asset/state")
    public List<AssetStateDto> getAllAssetState(){
        return Arrays.asList(AssetState.values()).stream().map(n -> n.toDto()).collect(Collectors.toList());
    }

    /**
     * ?????? ??????
     */
    @ResponseBody
    @PutMapping("/asset/{id}")
    public void updateAsset(@PathVariable(name = "id") long id, @RequestBody Asset asset){
        assetService.updateAsset(asset);
    }

    /**
     * ?????? ??????
     */
    @ResponseBody
    @DeleteMapping("/asset/{id}")
    public void deleteAsset(@PathVariable(name = "id") long id){
        assetService.deleteAsset(id);
    }

    /**
     * ?????? ????????? ?????? ????????????
     */
    @ResponseBody
    @GetMapping("/asset/excel")
    public void excelDownload(HttpServletResponse response) throws IOException{
        response.setHeader("Content-Disposition", "attachment;filename=asset_list.xls");
        response.setContentType("application/vnd.ms-excel");

        List<String> header = Arrays.asList("????????????", "???????????????", "?????? ??????", "?????????", "?????????", "????????????");
        List<AssetExcelOutputDto> assetList = assetService.getAllAssetForExcel();

        ByteArrayInputStream stream = ExcelUtils.createListToExcel(header, assetList);
        IOUtils.copy(stream, response.getOutputStream());
    }

    /**
     * ?????? ?????? ?????? ?????????
     */
    @ResponseBody
    @PostMapping("/asset/upload")
    public void excelUpload2(@RequestPart(name = "file") MultipartFile mf) {
        List<Asset> assetList = new ArrayList<>();

        List<Map<String, Objects>> mapList;
    }

}
