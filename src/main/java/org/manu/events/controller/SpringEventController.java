package org.manu.events.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Map;

@Controller
//@RequestMapping(method = RequestMethod.GET)
public class SpringEventController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/hello/{name}")
    public String greetAction(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "/greet";
    }

    @RequestMapping("/foo")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }
}

