package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //MVC 방식으로 HELLO SPRING  테스트
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","Hello Spring!!!!");
        return "hello";
    }

    // MVC 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }


    // API 방식, 데이터 넘김, 클라이언트 서버 React와 같이 개발할 때 사용
    @GetMapping("hello-string")
    @ResponseBody //HTTP BODY 부에 데이터 직접 넣어줌
    public String helloStirng(@RequestParam("name") String name ) {
        return "hello " + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);

        return hello; // HTTP BODY부에 스프링이 자동으로 객체를 JSON 타입으로 반환해서 전달
    }

    static class Hello{

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
