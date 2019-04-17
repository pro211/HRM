package com.nc.hrm.controller.admin;

import com.nc.hrm.util.Pages;
import com.nc.hrm.model.entity.Certificate;
import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.service.CertificateService;
import com.nc.hrm.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("admin/certificate")
    public String index(Model model){
        model.addAttribute("certificate", certificateService.findAll());
        return Pages.AD_CERTIFICATE_LIST;
    }

    /**
     * ghghghg
     * @param model
     * @return
     */
    @GetMapping("/admin/certificate/create")
    public String create(Model model) {
        model.addAttribute("certificate", new Certificate());
        return Pages.AD_CERTIFICATE_FORM;
    }

    // Edit
    @GetMapping("/admin/certificate/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("certificate", certificateService.finById(id));
        return Pages.AD_CERTIFICATE_FORM;
    }

    // Save or Update
    @PostMapping("/admin/certificate/save")
    public String save(@Valid Certificate certificate, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return Pages.AD_CERTIFICATE_FORM;
        }
        certificateService.save(certificate);
        return "redirect:/admin/certificate";
    }

    // Delete
    @GetMapping("/admin/certificate/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        certificateService.delete(id);
        return "redirect:/admin/certificate";
    }

    @ModelAttribute("listEmployee")
    public Iterable<Employee> getEmployees(){
        return employeeService.findAll();
    }
}
