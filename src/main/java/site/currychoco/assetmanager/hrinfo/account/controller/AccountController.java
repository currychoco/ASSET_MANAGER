package site.currychoco.assetmanager.hrinfo.account.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.currychoco.assetmanager.hrinfo.account.domain.AccountDto;
import site.currychoco.assetmanager.hrinfo.account.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/account/login")
    public boolean login(@RequestParam String id, @RequestParam String password, HttpServletRequest request){

        AccountDto result = accountService.login(id, password);

        if(result != null){

            HttpSession session = request.getSession();
            session.setAttribute("id", result.getId());
            session.setAttribute("empNo", result.getEmpNo());
            /*
            // 로그인 된 계정의 권한 확인하기
            List<String> grantList = accountAuthorityService.getAllGrant(result.getEmpNo());
            Collections.sort(grantList);

            if(grantList.size() != 0){
                session.setAttribute("grant", grantList);
            }
             */
        }
        return result != null;
    }

    // 로그아웃
    @ResponseBody
    @PostMapping("/account/logout")
    public void logout(HttpServletRequest request){
        request.getSession().invalidate();
    }
}
