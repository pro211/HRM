package com.nc.hrm.controller.admin;

import com.nc.hrm.model.entity.Contract;
import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.entity.JobTitle;
import com.nc.hrm.model.service.ContractService;
import com.nc.hrm.model.service.ContractTypeService;
import com.nc.hrm.model.service.EmployeeService;
import com.nc.hrm.model.service.JobtitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class AdminContractController {
    @Autowired
    ContractService contractService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    JobtitleService jobtitleService;

    @Autowired
    ContractTypeService contractTypeService;

    @GetMapping("/admin/contract")
    public String getContracts(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("contracts", contractService.findAll(PageRequest.of(page,5)));
        model.addAttribute("contractFilters", contractService.findAll());
        model.addAttribute("currentPage", page);
        int totalPage = contractService.findAll(PageRequest.of(page, 5)).getTotalPages() -1;
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("positions", jobtitleService.findAll());
        model.addAttribute("contractTypes", contractTypeService.findAll());

        return "admin/contracts";
    }

    @GetMapping("/admin/contract/find")
    @ResponseBody
    public Map<String,Object> findContract(int id){
        Map<String,Object> map=new HashMap<>();
        Contract contract = contractService.findById(id);
        Employee employee = employeeService.findById(contract.getEmployee().getId());
        JobTitle jobTitle = jobtitleService.findById(contract.getPosition().getId());

        map.put("contract",contract);
        map.put("employee",employee);
        map.put("position",jobTitle);
        return map;
    }

    @PostMapping("/admin/contract/save")
    public String saveContract(Contract contract) {
        System.out.println(contract.toString());
        contractService.save(contract);
        return "redirect:/admin/contract";
    }

    @GetMapping("/admin/contract/delete")
    public String deleteContract (Integer id) {
        contractService.delete(id);
        return "redirect:/admin/contract";
    }
}
