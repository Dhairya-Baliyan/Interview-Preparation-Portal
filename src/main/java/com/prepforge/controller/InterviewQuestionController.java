package com.prepforge.controller;

import com.prepforge.model.Category;
import com.prepforge.model.Difficulty;
import com.prepforge.model.InterviewQuestion;
import com.prepforge.service.InterviewQuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/questions")
public class InterviewQuestionController {

    private final InterviewQuestionService interviewQuestionService;

    public InterviewQuestionController(
            InterviewQuestionService interviewQuestionService) {
        this.interviewQuestionService = interviewQuestionService;
    }

    @GetMapping
    public String listQuestions(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) Difficulty difficulty,
            Model model) {

        model.addAttribute(
                "questions",
                interviewQuestionService.searchQuestion(
                        keyword,
                        category,
                        difficulty)
        );

        model.addAttribute("keyword", keyword);
        model.addAttribute("selectedCategory", category);
        model.addAttribute("selectedDifficulty", difficulty);
        model.addAttribute("categories", Category.values());
        model.addAttribute("difficulties", Difficulty.values());

        return "question/list";
    }

    @GetMapping("/{id}")
    public String viewQuestion(
            @PathVariable Long id,
            Model model) {

        return interviewQuestionService.getQuestionById(id)
                .map(question -> {
                    model.addAttribute("question", question);
                    return "question/detail";
                })
                .orElse("redirect:/questions");
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("question", new InterviewQuestion());
        model.addAttribute("categories", Category.values());
        model.addAttribute("difficulties", Difficulty.values());

        model.addAttribute("formAction", "/questions");

        return "question/form";
    }

    @PostMapping
    public String createQuestion(
            @ModelAttribute("question") InterviewQuestion question) {

        InterviewQuestion savedQuestion =
                interviewQuestionService.createQuestion(question);

        return "redirect:/questions/" + savedQuestion.getId();
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(
            @PathVariable Long id,
            Model model) {

        return interviewQuestionService.getQuestionById(id)
                .map(question -> {
                    model.addAttribute("question", question);
                    model.addAttribute("categories", Category.values());
                    model.addAttribute("difficulties", Difficulty.values());

                    model.addAttribute("formAction", "/questions/" + id + "/edit");
                    return "question/form";
                })
                .orElse("redirect:/questions");
    }

    @PostMapping("/{id}/edit")
    public String updateQuestion(
            @PathVariable Long id,
            @ModelAttribute("question") InterviewQuestion updatedQuestion) {

        return interviewQuestionService
                .updateQuestion(id, updatedQuestion)
                .map(question -> "redirect:/questions/" + question.getId())
                .orElse("redirect:/questions");
    }

    @PostMapping("/{id}/delete")
    public String deleteQuestion(@PathVariable Long id) {
        interviewQuestionService.deleteQuestion(id);
        return "redirect:/questions";
    }
}