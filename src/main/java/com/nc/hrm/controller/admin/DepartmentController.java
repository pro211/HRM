package com.nc.hrm.controller.admin;

import com.nc.hrm.util.Pages;
import com.nc.hrm.model.entity.Branch;
import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Index
    @GetMapping("/admin/department")
    public String index(ModelMap model) {
        model.addAttribute("department", departmentService.findAll());
        return Pages.AD_DEPARTMENT_LIST;
    }

    // Create
    @GetMapping("/admin/department/create")
    public String create(Model model) {
        model.addAttribute("department", new Branch());
        return Pages.AD_DEPARTMENT_FORM;
    }

    // Edit
    @GetMapping("/admin/department/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("department", departmentService.finById(id));
        return Pages.AD_DEPARTMENT_FORM;
    }

    // Save or Update
    @PostMapping("/admin/department/save")
    public String save(@Valid Department department, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return Pages.AD_DEPARTMENT_FORM;
        }
        departmentService.save(department);
        return "redirect:/admin/department";
    }

    // Delete
    @GetMapping("/admin/department/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        departmentService.delete(id);
        return "redirect:/admin/department";
    }
}
