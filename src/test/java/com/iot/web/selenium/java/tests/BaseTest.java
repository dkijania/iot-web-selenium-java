package com.iot.web.selenium.java.tests;

import com.iot.web.selenium.java.TestConfiguration;
import com.iot.web.selenium.java.ui.page.home.Home;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(classes = {TestConfiguration.class})
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected TestConfiguration testConfiguration;

    @Autowired
    private WebDriver webDriver;

    @Autowired
    protected Home home;

    @BeforeSuite
    public void before() throws Exception {
        springTestContextPrepareTestInstance();
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        navigateToMainPage();
    }

    @AfterTest
    public void afterTest() throws Exception {
        webDriver.close();
        webDriver.quit();
    }

    protected void navigateToMainPage() {
        webDriver.get(testConfiguration.getMainUrl());

    }
}