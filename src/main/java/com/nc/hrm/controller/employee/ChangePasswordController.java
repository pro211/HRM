package com.nc.hrm.controller.employee;

import com.nc.hrm.model.entity.ChangePassword;
import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.entity.Leave;
import com.nc.hrm.model.service.EmployeeService;
import com.nc.hrm.model.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ChangePasswordController {

    private final EmployeeService employeeService;

    @GetMapping("/employee/password")
    public String home(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        ChangePassword changePassword = new ChangePassword();
        changePassword.setId(employee.getId());
        model.addAttribute("changePassword", changePassword);
        model.addAttribute("passwordActive", true);
        return "us_changepassword";
    }

    @PostMapping("/employee/saveChangePassword")
    public String saveChangePassword(@Valid ChangePassword changePassword, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "us_changepassword";
        }

        Employee employee = employeeService.finById(changePassword.getId());
        String checkPass = employee.getPassword();
        if(checkPass.equals(changePassword.getPassword())){
            if(changePassword.getNewPassword().equals(changePassword.getVerifyPassword())){
                employee.setPassword(changePassword.getNewPassword());
                employeeService.save(employee);
            }
        }
        return "redirect:/employee/profile";
    }
}
