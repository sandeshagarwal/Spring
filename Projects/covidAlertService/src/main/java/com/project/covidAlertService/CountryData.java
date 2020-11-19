package com.project.covidAlertService;

import java.time.ZonedDateTime;

public class CountryData {
    private SummaryData summary;
    private StateData[] regional;

    public SummaryData getSummary() {
        return summary;
    }

    public void setSummary(SummaryData summary) {
        this.summary = summary;
    }

    public StateData[] getRegional() {
        return regional;
    }

    public void setRegional(StateData[] regional) {
        this.regional = regional;
    }

}