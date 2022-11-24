package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URLEncoder;

@Controller
public class RegisterController {

//    @RequestMapping(value = "/register/add", method = {RequestMethod.GET, RequestMethod.POST})
//    @RequestMapping("/register/add") // 신규회원 가입 화면

    // 단순히 url 연결만 하는 메서드 .. WEB-INF/spring/servlet-context.xml 에서 추가 가능
    // <!-- GET 요청만 허용, POST 요청 허용X -->
    // <view-controller path="/register/add" view-name="registerForm"/>
//    @GetMapping("/register/add")
//    public String register() {
//        return "registerForm"; // WEB-INF/views/registerForm.jsp
//    }



//    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    @PostMapping("/register/save")  // PostMapping : Spring 4.3부터
    public String save(User user, Model model) throws Exception {
        // 1. 유효성 검사
        if (!isValid(user)) {
            //String msg = "ID를 잘못 입력하셨습니다.";
            String msg = URLEncoder.encode("ID를 잘못 입력하셨습니다.", "UTF-8");

            // 2개 같은 의미 ("redirect" 요청에 있는 Model 이기 때문에 model에 값이 있으면 자동으로 바뀜)
            //return "redirect:/register/add?msg="+msg; // URL재작성(rewriting)
            model.addAttribute("msg", msg);
            return "redirect:/register/add"; // URL재작성(rewriting)

            //return "forward:/register/add";
        }

        // 2. DB에 신규회원 정보를 저장

        return "registerInfo";
    }

    private boolean isValid(User user) {
        return false;
    }
}
