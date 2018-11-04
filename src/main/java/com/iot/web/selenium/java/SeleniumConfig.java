package com.iot.web.selenium.java;

import com.iot.web.selenium.java.TestConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SeleniumConfig implements FactoryBean<WebDriver> {

    @Autowired
    private TestConfiguration testConfiguration;

    @Override
    public WebDriver getObject() throws Exception {
        WebDriver driver = getChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", testConfiguration.getChromeDriverPath());
        return new ChromeDriver();
    }


    @Override
    public Class<WebDriver> getObjectType() {
        return WebDriver.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}