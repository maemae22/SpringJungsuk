package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class YoilTellerMVC5 {

    // 예외 처리
    @ExceptionHandler(Exception.class)
    public String catcher(Exception e) {
        e.printStackTrace();
        return "yoilError";
    }

    @RequestMapping("/getYoilMVC5") // http://localhost/ch2/getYoilMVC5
//    public String main(@ModelAttribute("myDate") MyDate date, Model model) { // 아래와 동일
//    public String main(@ModelAttribute MyDate date, Model model) {
    public String main(MyDate date, Model model) { // 참조형 매개변수 앞에는 @ModelAttribute 생략 가능

        // 1. 유효성 검사
    	if(!isValid(date)) {
            return "yoilError";  // 유효하지 않으면, /WEB-INF/views/yoilError.jsp로 이동
        }

        // 2. 처리 : 요일 계산
//    	char yoil = getYoil(date);  // @ModelAttribute 어노테이션이 자동으로 호출

        // 3. Model에 작업 결과 저장 : 계산한 결과를 model에 저장
//        model.addAttribute("myDate", date);
//        model.addAttribute("yoil", yoil);
        
        // 4. 작업 결과를 보여줄 View의 이름을 반환
        return "yoil"; // /WEB-INF/views/yoil.jsp
    }

    private boolean isValid(MyDate date) {
        return isValid(date.getYear(), date.getMonth(), date.getDay());
    }

    private @ModelAttribute("yoil") char getYoil(MyDate date) {
        return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }

    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) {
            return false;
        }
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
}
