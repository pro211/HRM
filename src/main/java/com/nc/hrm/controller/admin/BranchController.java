package com.nc.hrm.controller.admin;

import com.nc.hrm.util.Pages;
import com.nc.hrm.model.entity.Branch;
import com.nc.hrm.model.service.BranchService;
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
public class BranchController {
    @Autowired
    private BranchService branchService;

    /**
     *
     * @param model
     * @return admin branch page
     */
    @GetMapping("/admin/branch")
    public String index(ModelMap model) {
        model.addAttribute("branch", branchService.findAll());
        return Pages.AD_BRANCH;
    }

    /**
     *
     * @param model
     * @return
     */

    @GetMapping("/admin/branch/create")
    public String create(Model model) {
        model.addAttribute("branch", new Branch());
        return Pages.AD_BRANCH_FORM;
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/admin/branch/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("branch", branchService.finById(id));
        return Pages.AD_BRANCH_FORM;
    }

    /**
     *
     * @param branch
     * @param result
     * @param redirect
     * @return
     */
    @PostMapping("/admin/branch/save")
    public String save(@Valid Branch branch, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return Pages.AD_BRANCH_FORM;
        }
        System.out.println("Branch" + branch);
        branchService.save(branch);
        return "redirect:/admin/branch";
    }

    /**
     *
     * @param id
     * @param redirect
     * @return
     */
    @GetMapping("/admin/branch/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        branchService.delete(id);
        return "redirect:/admin/branch";
    }
}
