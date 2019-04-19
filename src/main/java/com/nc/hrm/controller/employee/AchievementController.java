package com.nc.hrm.controller.employee;

import com.nc.hrm.model.entity.Achievement;
import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.service.AchievementService;
import com.nc.hrm.model.service.EmployeeService;
import com.nc.hrm.model.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AchievementController {

    private final AchievementService achievementService;

    @GetMapping("employee/achievement")
    public String home(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        List<Achievement> achievements = achievementService.findByEmployeeId(2);
        model.addAttribute("achievement", true);
        model.addAttribute("achievements", achievements);
        return "us_achievement";
    }


}
