package com.portfolio.cv.controller;

import com.portfolio.cv.entity.Skill;
import com.portfolio.cv.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SkillController {
    @Autowired private SkillService skillService;

    @GetMapping("/skill")
    public String showSkill(Model model){
        List<Skill> skills = skillService.listAll();
        model.addAttribute("skills", skills);

        return "skill";
    }
}
