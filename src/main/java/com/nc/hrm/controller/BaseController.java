package com.nc.hrm.controller;

import com.nc.hrm.model.enums.MaritalStatus;
import com.nc.hrm.util.EnumAdapter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class BaseController {

    @GetMapping("/")
    public String index(Authentication authentication) {
        if (StringUtils.equals(authentication.getAuthorities().stream().findFirst().get().toString(), "ROLE_ADMIN"))
            return "redirect:/admin/home";
        return "redirect:/employee/profile";

    }

    @GetMapping("/admin/home")
    public String homeAdmin(){
        return "base/index";
    }
}
