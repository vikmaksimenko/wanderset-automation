package com.wanderset.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.TestResult;
import io.qameta.allure.selenide.AllureSelenide;

import java.util.function.Consumer;

import static org.junit.Assert.fail;

public class Hooks {
    @Before
    public void setUp(Scenario scenario) {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1024x768";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.remote = "http://localhost:4444/wd/hub";

        SelenideLogger.addListener("AllureSelenide", new CustomAllureSelenide().screenshots(true).savePageSource(true));

        for (String tag : scenario.getSourceTagNames()) {
            if (tag.contains("issue")) {
                fail("foo");
            }
        }


    }

    @After
    public void tearDown() {
//        AllureLifecycle lifecycle = Allure.getLifecycle();
//
//        String testCase = lifecycle.getCurrentTestCase().get();
//        lifecycle.updateTestCase(new Consumer<TestResult>() {
//            @Override
//            public void accept(TestResult testResult) {
//
//            }
//        });

//        Allure.getLifecycle().storage.getTestResult("06541a65-5b69-436b-9639-177f184ab716").value.setStatus(Status.SKIPPED)
    }
}
