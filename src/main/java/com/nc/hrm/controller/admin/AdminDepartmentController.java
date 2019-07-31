package com.nc.hrm.controller.admin;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class AdminDepartmentController {
    @Autowired
    private DepartmentService departmentService;

    // List
    @GetMapping("/admin/department")
    public String getDepartments(Model model, @RequestParam(defaultValue="0") int page){
        model.addAttribute("departments", departmentService.findAll(PageRequest.of(page, 5)));
        model.addAttribute("departmentFilters", departmentService.fillAll());
        model.addAttribute("currentPage", page);
        int totalPage = departmentService.findAll(PageRequest.of(page, 5)).getTotalPages() -1;
        model.addAttribute("totalPage", totalPage);
        return "admin/departments";
    }

    // Save
    @PostMapping("/admin/department/save")
    public String save(Department department) {
        departmentService.save(department);
        return "redirect:/admin/department";
    }

    // Delete
    @GetMapping("/admin/department/delete")
    public String delete(Integer id) {
        departmentService.delete(id);
        return "redirect:/admin/department";
    }

    // getOne
    @GetMapping("/admin/department/find")
    @ResponseBody
    public Department getOne(Integer id) {
        Department department = departmentService.findById(id);
        return department;
    }
}
