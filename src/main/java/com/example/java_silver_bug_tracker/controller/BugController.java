package com.example.java_silver_bug_tracker.controller;
import com.example.java_silver_bug_tracker.model.Bug;
import com.example.java_silver_bug_tracker.repository.BugRepository;
import com.example.java_silver_bug_tracker.service.BugService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BugController {
    private final BugService bugService;

    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @GetMapping("/bugs")
    public String listBug(Model model ) {
        /* <tr th:each="bug : ${bugs}">　のbugsにつながっている */
        model.addAttribute("bugs", bugService.findAll());
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

    @GetMapping("/bugs/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model)
    {
        // 1. Serviceを使って、そのIDのバグ情報を取得する
        Bug bug = bugService.findById(id);

        // 2. 取得したバグ情報を画面に渡す
        // (新規登録の時と同じ "bugForm" という名前で渡すとHTMLを再利用しやすいらしい)
        model.addAttribute("bugForm", bug);

        return "bug-edit";
    }

    // 編集画面から「更新する」ボタンが押された時の処理
    @PostMapping("/bugs/update")
    public String updateBug(@ModelAttribute Bug bug) {
        // 隠しフィールド(id)が入った状態のbugが渡されるので、
        // saveメソッドは自動的に「新規」ではなく「更新(上書き)」と判断してくれます
        bugService.save(bug);

        return "redirect:/bugs";
    }
}
