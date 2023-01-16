package com.api.automation.service;

import com.epam.reportportal.listeners.LogLevel;
import com.epam.reportportal.restassured.ReportPortalRestAssuredLoggingFilter;
import io.restassured.RestAssured;

public class Service {

    static {
        RestAssured.filters(new ReportPortalRestAssuredLoggingFilter(42, LogLevel.INFO));
    }
}
