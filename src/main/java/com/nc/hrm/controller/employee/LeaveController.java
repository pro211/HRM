package com.nc.hrm.controller.employee;

import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.service.EmployeeService;
import com.nc.hrm.util.Pages;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LeaveController {

    private final EmployeeService employeeService;

    @GetMapping("/employee/leave")
    public String home(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        System.out.println(employee);
        //model.addAttribute("profile", employeeService.findByCode(code));
        return "us_leave";
    }

}
