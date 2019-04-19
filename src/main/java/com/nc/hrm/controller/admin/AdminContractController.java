package com.nc.hrm.controller.admin;

import com.nc.hrm.model.entity.Contract;
import com.nc.hrm.model.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AdminContractController {

    private final ContractService contractService;

    @GetMapping("/admin/contract")
    public String getContractPage(Model model) {
        model.addAttribute("contracts", contractService.findAll());
        return "ad.contract";
    }

    @GetMapping("/admin/contract/create")
    public String createContract(Model model) {
        model.addAttribute("contract", new Contract());
        return "ad.contract.add";
    }

    @PostMapping("/admin/contract/create")
    public String saveContract(@Valid Contract contract, BindingResult result) {
        if(result.hasErrors()) {
            return "ad.contract.add";
        }
        contractService.save(contract);
        return "redirect:/ad.contract";
    }

    @PostMapping("/admin/contract/delete/{id}")
    public String deleteContract(@PathVariable("id") Integer id) {
        contractService.delete(id);
        return "redirect:/ad.contract";
    }
}
