package com.nc.hrm.controller.employee;

import com.nc.hrm.model.entity.Achievement;
import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.service.EmployeeService;
import com.nc.hrm.model.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AchievementController {

    private final EmployeeService employeeService;
    private final LeaveService leaveService;


    @GetMapping("/employee/achievement")
    public String home(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        Set<Achievement> achievement = employeeService.findByBusinessName(employee.getBusinessName()).getAchievements();
        model.addAttribute("achievement", achievement);
        return "us_achievement";
    }

}
