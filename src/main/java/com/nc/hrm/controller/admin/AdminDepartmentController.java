package com.nc.hrm.controller.admin;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AdminDepartmentController {

    private final DepartmentService departmentService;

    // List
    @GetMapping("/admin/department")
    public String getDepartments(Model model, @RequestParam(defaultValue="0") int page) throws JsonGenerationException, JsonMappingException, IOException {
        model.addAttribute("departments", departmentService.findAll(PageRequest.of(page, 5)));
        model.addAttribute("currentPage", page);
        int totalPage = departmentService.findAll(PageRequest.of(page, 4)).getTotalPages() -1;
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
        Department department = departmentService.findOne(id);
        return department;
    }
}
