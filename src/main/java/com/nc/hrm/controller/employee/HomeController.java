package com.nc.hrm.controller.employee;

import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.service.EmployeeService;
import com.nc.hrm.util.Pages;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping("/employee")
public class HomeController {

    private final EmployeeService employeeService;

    @GetMapping("/home")
    public String home() {
        return Pages.HOME;
    }

    @ModelAttribute("code")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    // Hồ sơ nhân viên
    @GetMapping("/{code}/profile")
    public String profile(@PathVariable String code, Model model) {
        model.addAttribute("profile", employeeService.findByCode(code));
        return Pages.PROFILE;
    }

    // Sửa thông tin nhân viên
    @GetMapping("/{code}/editprofile")
    public String editProfile(@PathVariable String code, Model model) {
        model.addAttribute("profile", employeeService.findByCode(code));
        return Pages.PROFILE_FORM;
    }

    // Save thông tin nhân viên
    @PostMapping("/save")
    public String saveProfile(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return Pages.PROFILE_FORM;
        }
        employeeService.save(employee);
        return "redirect:/employee/" + employee.getCode() + "/profile";
    }
}
