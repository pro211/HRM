package com.nc.hrm.controller.employee;

import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.service.EmployeeService;
import com.nc.hrm.util.Pages;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HomeController {

    private final EmployeeService employeeService;


    @GetMapping("/employee/profile")
    public String home(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        model.addAttribute("profile", employeeService.findByBusinessName(employee.getBusinessName()));
        return "us_profile";
    }

    @GetMapping("/employee/editprofile")
    public String editProfile(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        model.addAttribute("profile", employeeService.findByBusinessName(employee.getBusinessName()));
        return "us_profile_form";
    }

    @PostMapping("/employee/save")
    public String saveProfile(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return Pages.PROFILE_FORM;
        }
        employeeService.save(employee);
        return "redirect:/employee/profile";
    }
}
