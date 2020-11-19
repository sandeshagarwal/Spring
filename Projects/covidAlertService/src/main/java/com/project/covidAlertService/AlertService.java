package com.project.covidAlertService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AlertService {
    @Autowired
    private CovidDataProvider covidDataProvider;


    public AlertStatus getAlertAboutState(String state) {
        AlertStatus alertStatus = new AlertStatus();

        StateData stateData = covidDataProvider.getStateData(state);

        alertStatus.setSummaryData(stateData);
        if(stateData.getTotalConfirmed() < 20000){
            alertStatus.setAlertLevel("GREEN");
            alertStatus.setMeasuresToBeTaken(Arrays.asList("Everything is Normal"));
        }
        else if(stateData.getTotalConfirmed() > 20000 & stateData.getTotalConfirmed() < 250000)
        {
            alertStatus.setAlertLevel("ORANGE");
            alertStatus.setMeasuresToBeTaken(Arrays.asList("Weekend Lockdown"));
        }
        else {
            alertStatus.setAlertLevel("RED");
            alertStatus.setMeasuresToBeTaken(Arrays.asList("Full Lockdown, Only essential services are allowed"));
        }


        return alertStatus;
    }

    public SummaryData getOverallSummary() {
        return covidDataProvider.getSummaryData("summary");
    }
}
