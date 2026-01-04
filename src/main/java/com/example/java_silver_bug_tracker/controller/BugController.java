package com.example.java_silver_bug_tracker.controller;
import com.example.java_silver_bug_tracker.model.Bug;
import com.example.java_silver_bug_tracker.repository.BugRepository;
import com.example.java_silver_bug_tracker.service.BugService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BugController {
    private final BugService bugService;

    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @GetMapping("/bugs")
    public String listBug(Model model ) {
        model.addAttribute("bug", bugService.findAll());
        return "bug-list";
    }

    @GetMapping("bugs/new")
    public String showCreateForm(Model model) {
        model.addAttribute("bugForm", new Bug());
        return "bug-form";
    }

    @PostMapping("bugs/new")
    public String NewBug(@ModelAttribute Bug bug) {
        bugService.save(bug);
        return "redirect:/bugs";
    }

}
