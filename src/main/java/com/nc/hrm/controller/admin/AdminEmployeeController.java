package com.nc.hrm.controller.admin;

import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.service.DepartmentService;
import com.nc.hrm.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminEmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/admin/employee")
    public String getEmployees(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("employees",employeeService.findAll(PageRequest.of(page,4)));
        model.addAttribute("employeefilters", employeeService.findAll());
        model.addAttribute("currentPage", page);
        int totalPage = employeeService.findAll(PageRequest.of(page,4)).getTotalPages() - 1;
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("departments", departmentService.findAll());
        return "admin/employees";
    }

    @GetMapping("/admin/employee/find")
    @ResponseBody
    public Map<String,Object> findEmployee(Integer id) {
        Map<String,Object> map=new HashMap<>();
        Employee emp = employeeService.findById(id);
        Department dep = departmentService.findById(emp.getDepartment().getId());
        map.put("employee",emp);
        map.put("department",dep);
        return map;
    }

    @PostMapping("/admin/employee/save")
    public String saveEmployee(Employee employee) {
        employeeService.save(employee);
        System.out.println(employee);
        return "redirect:/admin/employee";
    }

    @GetMapping("/admin/employee/delete")
    public String deleteEmployee (Integer id) {
        employeeService.delete(id);
        System.out.println("vao day");
        return "redirect:/admin/employee";
    }

    @GetMapping("/admin/employee/findEmp")
    @ResponseBody
    public Employee findEmp(String businessName) {
        Employee employee = employeeService.findByBusinessName(businessName);
        return employee;
    }
}
