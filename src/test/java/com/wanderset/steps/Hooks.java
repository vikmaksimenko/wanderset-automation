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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                String message = "The case is marked with @issue.";

                Pattern pattern = Pattern.compile("@issue=(.*)");
                Matcher matcher = pattern.matcher(tag);
                if(matcher.matches()) {
                    String linkPattern = System.getProperty("allure.link.issue.pattern");
                    String link = linkPattern.replace("{}", matcher.group(1));
                    message += "Sea details in " + link;
                }

                fail(message);
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
