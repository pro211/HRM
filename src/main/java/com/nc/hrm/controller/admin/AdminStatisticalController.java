package com.nc.hrm.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminStatisticalController {
    @GetMapping("/admin/statistical")
    public String getStatistical(Model model) {
        return "admin/statisticals";
    }
}
