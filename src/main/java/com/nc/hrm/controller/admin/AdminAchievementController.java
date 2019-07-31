package com.nc.hrm.controller.admin;

import com.nc.hrm.model.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AdminAchievementController {
    private final AchievementService achievementService;


}
