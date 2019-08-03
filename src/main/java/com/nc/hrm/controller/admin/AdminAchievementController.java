package com.nc.hrm.controller.admin;

import com.nc.hrm.model.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminAchievementController {
    @Autowired
    AchievementService achievementService;

    @GetMapping("/admin/achievement")
    public String getContracts(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("achievements", achievementService.findAll(PageRequest.of(page,5)));
        return "admin/achievements";
    }
}
