package com.configurations;

import com.codeborne.selenide.Configuration;

import static com.globalActivities.OverrideCommands.applyNewCommands;

public class SetUp {

    public void browserConfigurations() {
        applyNewCommands();
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.google.com/";
        Configuration.headless = false;
        //Configuration.startMaximized = false;
        Configuration.browserSize = "1900x1080"; //1920x1080 1024x768
        Configuration.holdBrowserOpen = false;
        Configuration.fastSetValue = true;
        Configuration.timeout = 40000;
    }
}
