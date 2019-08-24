package com.nc.hrm.controller.employee;

import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.entity.Leave;
import com.nc.hrm.model.entity.LeaveStatus;
import com.nc.hrm.model.service.EmployeeService;
import com.nc.hrm.model.service.LeaveService;
import com.nc.hrm.util.Pages;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LeaveController {

    private final LeaveService leaveService;

    @GetMapping("/employee/leave")
    public String home(Authentication authentication, Model model) {
        Employee employee = (Employee) authentication.getPrincipal();
        List<Leave> leave = leaveService.findByEmployeeId(employee.getId());
        model.addAttribute("leaveActive", true);
        model.addAttribute("leave", leave);
        return "employee/leave";
    }

    @GetMapping("/employee/newleave")
    public String editProfile(Model model) {
        Leave leave = new Leave();
        model.addAttribute("leave", leave);
        model.addAttribute("leaveActive", true);
        return "employee/leave_form";
    }

    @PostMapping("/employee/leave/save")
    public String saveProfile(@Valid Leave leave, Authentication authentication,BindingResult result, RedirectAttributes redirect) {
        leave.setApplyDate(LocalDate.now());
        Employee employee = (Employee) authentication.getPrincipal();
        leave.setEmployee(employee);
        LeaveStatus leaveStatus = new LeaveStatus();
        leaveStatus.setId(4);
        leave.setStatus(leaveStatus);
        if (result.hasErrors()) {
            return "employee/leave_form";
        }
        leaveService.save(leave);
        return "redirect:/employee/leave";
    }

    @GetMapping("/employee/leave/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        leaveService.delete(id);
        return "redirect:/employee/leave";
    }
}
