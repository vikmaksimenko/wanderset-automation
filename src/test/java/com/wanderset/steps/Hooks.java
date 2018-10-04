package com.wanderset.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import cucumber.api.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

public class Hooks {
    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1024x768";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }
}
