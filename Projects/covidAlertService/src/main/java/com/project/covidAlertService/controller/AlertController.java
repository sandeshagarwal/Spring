package com.project.covidAlertService.controller;

import com.project.covidAlertService.AlertService;
import com.project.covidAlertService.AlertStatus;
import com.project.covidAlertService.SummaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/india/")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping("/{state}")
    AlertStatus getAlertAboutState(@PathVariable String state)
    {
        return alertService.getAlertAboutState(state);
    }
    @GetMapping("/summary")
    SummaryData getOverallSummary(String state){
        return alertService.getOverallSummary();
    }
}
