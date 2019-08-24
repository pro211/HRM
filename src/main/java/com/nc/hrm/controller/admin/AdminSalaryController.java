package com.nc.hrm.controller.admin;

import com.nc.hrm.model.entity.*;
import com.nc.hrm.model.service.AchievementService;
import com.nc.hrm.model.service.ContractService;
import com.nc.hrm.model.service.EmployeeService;
import com.nc.hrm.model.service.SalaryService;
import com.nc.hrm.util.ExcelGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminSalaryController {

    @Autowired
    SalaryService salaryService;

    @Autowired
    AchievementService achievementService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ContractService contractService;

    @GetMapping("/admin/salary")
    public String getSalaries(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Salary> salaryList = salaryService.findAll(PageRequest.of(page,5));
        model.addAttribute("currentPage", page);
        int totalPage = salaryService.findAll(PageRequest.of(page, 5)).getTotalPages() -1;
        model.addAttribute("totalPage", totalPage);
        for (Salary s: salaryList) {
            long achievementSalary = 0;
            int empId = s.getEmployee().getId();
            List<Achievement> achievementList = achievementService.findByEmployeeId(empId);
            if(achievementList !=null){
                for (Achievement achievement: achievementList) {
                    if(s.getMonth() == achievement.getApplyDate().getMonthValue()
                            && s.getYear() == achievement.getApplyDate().getYear() && empId == achievement.getEmployee().getId()) {
                        achievementSalary += achievement.getAmount();
                        System.out.println("Vào 1");
                        s.setAchievement(achievementSalary);
                    }else {
                        System.out.println("Vào 2");
                        achievementSalary = 0;
                        s.setAchievement(achievementSalary);
                    }
                }
            }
            salaryService.save(s);
        }
        model.addAttribute("salaries", salaryList);
        return "admin/salaries";
    }

    @GetMapping("/admin/salary/find")
    @ResponseBody
    public Map<String,Object> findContract(int id){
        Map<String,Object> map=new HashMap<>();
        Salary salary = salaryService.findById(id);
        int empId = salary.getEmployee().getId();
        int contracId = salary.getContract().getId();
        Employee employee = employeeService.findById(empId);
        Contract contract = contractService.findById(contracId);
        map.put("salary",salary);
        map.put("employee",employee);
        map.put("contract",contract);
        return map;
    }

    @GetMapping("/admin/salary/download/salaries.xlsx")
    @ResponseBody
    public ResponseEntity<InputStreamResource> excelSalariesReport() throws IOException {
        List<Salary> salaries = (List<Salary>) salaryService.findAll();
        System.out.println(salaries.size());

        ByteArrayInputStream in = ExcelGenerator.salariesToExcel(salaries);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=salaries.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }

    @GetMapping("/admin/salary/download")
    @ResponseBody
    public ResponseEntity<InputStreamResource> excelEmployeeSalaryReport(int id) throws IOException {
        Salary salary = salaryService.findById(id);
        String codeEmp = salary.getContract().getEmployee().getBusinessName();
        ByteArrayInputStream in = ExcelGenerator.employeeSalaryToExcel(salary);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + codeEmp + ".xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }

    @PostMapping("/admin/salary/save")
    public String save(Salary salary) {
        salaryService.save(salary);
        return "redirect:/admin/salary";
    }

    @GetMapping("/admin/salary/delete")
    public String delete(Integer id) {
        salaryService.delete(id);
        return "redirect:/admin/salary";
    }

    @GetMapping("/admin/salary/findByEmployee")
    @ResponseBody
    public List<Salary> findByEmployee(int id) {
        List<Salary> listSalary = salaryService.findByEmployeeId(id);
        return listSalary;
    }
}

