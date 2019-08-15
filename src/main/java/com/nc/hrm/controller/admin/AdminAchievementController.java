package com.nc.hrm.controller.admin;

import com.nc.hrm.model.entity.Achievement;
import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.service.AchievementService;
import com.nc.hrm.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminAchievementController {
    @Autowired
    AchievementService achievementService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/admin/achievement")
    public String getContracts(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("achievements", achievementService.findAll(PageRequest.of(page,5)));
        model.addAttribute("achievementFilters", achievementService.findAll());
        model.addAttribute("currentPage", page);
        int totalPage = achievementService.findAll(PageRequest.of(page, 5)).getTotalPages() -1;
        model.addAttribute("totalPage", totalPage);
        return "admin/achievements";
    }

    @GetMapping("/admin/achievement/find")
    @ResponseBody
    public Map<String,Object> findContract(int id){
        Map<String,Object> map=new HashMap<>();
        Achievement achievement = achievementService.findById(id);
        Employee employee = employeeService.findById(achievement.getEmployee().getId());

        map.put("achievement",achievement);
        map.put("employee",employee);
        return map;
    }

    @PostMapping("/admin/achievement/save")
    public String saveContract(Achievement achievement) {
        achievementService.save(achievement);
        return "redirect:/admin/achievement";
    }

    @GetMapping("/admin/achievement/delete")
    public String deleteAchievement (Integer id) {
        achievementService.delete(id);
        return "redirect:/admin/achievement";
    }
}
