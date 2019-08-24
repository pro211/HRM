package com.nc.hrm.controller.admin;

import com.nc.hrm.model.entity.*;
import com.nc.hrm.model.service.EmployeeService;
import com.nc.hrm.model.service.LeaveService;
import com.nc.hrm.model.service.LeaveStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminLeaveController {
    @Autowired
    LeaveService leaveService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    LeaveStatusService leaveStatusService;

    @GetMapping("/admin/leave")
    public String getLeave(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("leaves", leaveService.findAll(PageRequest.of(page,5)));
        model.addAttribute("currentPage", page);
        model.addAttribute("status", leaveStatusService.findAll());
        model.addAttribute("leaveFilters", leaveService.findAll());
        int totalPage = leaveService.findAll(PageRequest.of(page, 5)).getTotalPages() -1;
        model.addAttribute("leaveStatusIsNot", leaveService.findByStatusIdIsNot(5));
        model.addAttribute("leaveStatus", leaveService.findByStatusId(5));
        model.addAttribute("totalPage", totalPage);
        return "admin/leaves";
    }

    @GetMapping("/admin/leaveStatus")
    public String getLeaveStatus(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("leaves", leaveService.findAll(PageRequest.of(page,5)));
        model.addAttribute("currentPage", page);
        model.addAttribute("status", leaveStatusService.findAll());
        model.addAttribute("leaveFilters", leaveService.findAll());
        int totalPage = leaveService.findAll(PageRequest.of(page, 5)).getTotalPages() -1;
        model.addAttribute("leaveStatusIsNot", leaveService.findByStatusIdIsNot(5));
        model.addAttribute("leaveStatus", leaveService.findByStatusId(5));
        model.addAttribute("totalPage", totalPage);
        return "admin/leavesStatus";
    }

    @GetMapping("/admin/leave/find")
    @ResponseBody
    public Map<String,Object> findContract(int id){
        Map<String,Object> map=new HashMap<>();
        Leave leave = leaveService.findById(id);
        Employee employee = employeeService.findById(leave.getEmployee().getId());
        LeaveStatus leaveStatus = leaveStatusService.findById(leave.getStatus().getId());

        map.put("leave",leave);
        map.put("employee",employee);
        map.put("status",leaveStatus);
        return map;
    }

    @PostMapping("/admin/leave/save")
    public String saveLeave(Leave leave) {
        leaveService.save(leave);
        return "redirect:/admin/leave";
    }

    @GetMapping("/admin/leave/delete")
    public String deleteLeave (Integer id) {
        leaveService.delete(id);
        return "redirect:/admin/leave";
    }

    @GetMapping("/admin/leave/findByEmployee")
    @ResponseBody
    public List<Leave> findByEmployee(int id) {
        List<Leave> listLeaves = leaveService.findByEmployeeId(id);
        return listLeaves;
    }
}
