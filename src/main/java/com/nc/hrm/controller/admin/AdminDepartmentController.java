package com.nc.hrm.controller.admin;

import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.service.DepartmentService;
import com.nc.hrm.util.Pages;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AdminDepartmentController {

    private final DepartmentService departmentService;

    // Index
    @GetMapping("/admin/department")
    public String index(ModelMap model) {
        model.addAttribute("department", departmentService.findAll());
        return "ad.department";
    }

    // Create
    @GetMapping("/admin/department/create")
    public String create(Model model) {
        model.addAttribute("department", new Department());
        return "ad.department.add";
    }

    // Edit
    @GetMapping("/admin/department/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("department", departmentService.finById(id));
        return "ad.department.add";
    }

    // Save or Update
    @PostMapping("/admin/department/save")
    public String save(@Valid Department department, BindingResult result) {
        if (result.hasErrors()) {
            return "ad.department.add";
        }
        departmentService.save(department);
        return "redirect:/admin/department";
    }

    // Delete
    @GetMapping("/admin/department/{id}/delete")
    public String delete(@PathVariable int id) {
        departmentService.delete(id);
        return "redirect:/admin/department";
    }
}
