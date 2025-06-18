package site.currychoco.assetmanager.request.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import site.currychoco.assetmanager.category.domain.Category;
import site.currychoco.assetmanager.category.service.CategoryService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RequestController {

    private final CategoryService categoryService;

    @GetMapping("/request/payment-request")
    public String home(Model model){
        List<Category> categoryDtoList = categoryService.getAllCategory();

        model.addAttribute("category", categoryDtoList);

        return "request/paymentRequest";
    }
}
