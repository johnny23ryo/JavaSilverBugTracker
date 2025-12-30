package com.example.java_silver_bug_tracker.controller;

import com.example.java_silver_bug_tracker.model.TestMessage;
import com.example.java_silver_bug_tracker.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    private final TestService service;

    // Serviceを受け取る
    public TestController(TestService service) {
        this.service = service;
    }

    // "http://localhost:8080/test-layers"にアクセスが来たら動く
    @GetMapping("/test-layers")
    public String index(Model model){

        // ServiceからModel(TestMessage)をもらう
        TestMessage msgObj  = service.getMessage();
        // 画面に渡す箱を入れる
        model.addAttribute("myMessage", msgObj.getContent());

        // test-view.htmlを表示しろと命令
        return "test-view";
    }






}
