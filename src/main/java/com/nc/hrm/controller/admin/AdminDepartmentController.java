package com.nc.hrm.controller.admin;

import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.service.DepartmentService;
import com.nc.hrm.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminDepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/admin/department")
    public String getDepartments(Model model, @RequestParam(defaultValue="0") int page){
        model.addAttribute("departments", departmentService.findAll(PageRequest.of(page, 5)));
        model.addAttribute("departmentFilters", departmentService.findAll());
        model.addAttribute("currentPage", page);
        int totalPage = departmentService.findAll(PageRequest.of(page, 5)).getTotalPages() -1;
        model.addAttribute("totalPage", totalPage);
        return "admin/departments";
    }

    @PostMapping("/admin/department/save")
    public String save(Department department) {
        departmentService.save(department);
        return "redirect:/admin/department";
    }

    @GetMapping("/admin/department/delete")
    public String delete(Integer id) {
        List<Employee> listEmp = employeeService.findByDepartmentId(id);
        if(listEmp.size() > 0) {
            System.out.println("Phong ban co: " + listEmp.size() + "nhan vien");
        }else {
            departmentService.delete(id);
        }
        return "redirect:/admin/department";
    }

    @GetMapping("/admin/department/find")
    @ResponseBody
    public Department getOne(Integer id) {
        Department department = departmentService.findById(id);
        return department;
    }
}
