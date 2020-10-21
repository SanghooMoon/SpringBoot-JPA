package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")    // URL매핑
    public String hello(Model model) {
        model.addAttribute("data", "spring^-^");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // 응답에 직접 값을 반환하는 어노테이션
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // "hello spring", 문자열 반환
    }

    @GetMapping("hello-api")
    @ResponseBody
    // @ResponseBody를 사용하면 HTTP의 Body에 문자 내용을 직접 반환환
    // ResopnseBody는 뷰리졸버 대신 HttpMessageConverter(인터페이스)가 동작, 객체는 -> Json, 문자열 -> String
    public Hello helloAPi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // 객체로 반환하면 JSON 형식으로 반환(Key, Value)
    }

    static class Hello {
        private String name;

        // window 단축키 : Alt - Insert로 빠르게 생성
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

}
