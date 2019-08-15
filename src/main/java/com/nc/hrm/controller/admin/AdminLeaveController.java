package com.nc.hrm.controller.admin;

import com.nc.hrm.model.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminLeaveController {
    @Autowired
    LeaveService leaveService;

    @GetMapping("/admin/leave")
    public String getContracts(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("leaves", leaveService.findAll(PageRequest.of(page,5)));
        model.addAttribute("currentPage", page);
        int totalPage = leaveService.findAll(PageRequest.of(page, 5)).getTotalPages() -1;
        model.addAttribute("totalPage", totalPage);
        return "admin/leaves";
    }
}
