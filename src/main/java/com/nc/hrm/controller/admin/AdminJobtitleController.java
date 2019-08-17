package com.nc.hrm.controller.admin;

import com.nc.hrm.model.entity.Contract;
import com.nc.hrm.model.entity.Department;
import com.nc.hrm.model.entity.Employee;
import com.nc.hrm.model.entity.JobTitle;
import com.nc.hrm.model.service.ContractService;
import com.nc.hrm.model.service.DepartmentService;
import com.nc.hrm.model.service.EmployeeService;
import com.nc.hrm.model.service.JobtitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AdminJobtitleController {

    private final JobtitleService jobtitleService;
    private final DepartmentService departmentService;
    private final ContractService contractService;

    @GetMapping("/admin/jobtitle")
    public String getContracts(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("jobtitles", jobtitleService.findAll(PageRequest.of(page, 5)));
        model.addAttribute("currentPage", page);
        int totalPage = jobtitleService.findAll(PageRequest.of(page, 5)).getTotalPages() - 1;
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("jobtitlefilters",jobtitleService.findAll());
        return "admin/jobtitles";
    }

    @PostMapping("/admin/jobtitle/save")
    public String saveJobtitle(JobTitle jobTitle) {
        jobtitleService.save(jobTitle);
        return "redirect:/admin/jobtitle";
    }

    @GetMapping("/admin/jobtitle/delete")
    public String deleteJobtitle(Model model, Integer id) {
        List<Contract> listContract = contractService.findByPositionId(id);
        boolean check = false;
        if (listContract.size()>0){
            model.addAttribute("error","Chức danh này đang tồn tại trong hợp đồng. Không thể xóa!!!");
            check=false;
        }else {
            jobtitleService.delete(id);
            check=true;
        }

        if (check){
            return "redirect:/admin/jobtitle";
        }else {
            return "admin/jobtitles";
        }
    }

    @GetMapping("/admin/jobtitle/find")
    @ResponseBody
    public Map<String, Object> findJobtitle(Integer id) {
        Map<String, Object> map = new HashMap<>();
        JobTitle job = jobtitleService.findById(id);
        Department dep = departmentService.findById(job.getDepartment().getId());
        map.put("jobtitle",job);
        map.put("department", dep);
        return map;
    }

}
