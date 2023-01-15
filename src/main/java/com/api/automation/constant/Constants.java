package com.api.automation.constant;

import com.api.automation.util.ReadConfig;

public class Constants {

    public final static String USER_SERVICE_BASE_URL = ReadConfig.getProperty("user.service.baseUrl");
    public final static String PET_SERVICE_BASE_URL = ReadConfig.getProperty("pet.service.baseUrl");
}
