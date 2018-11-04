package com.iot.web.selenium.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.iot.web.selenium.java")
@PropertySource("classpath:test.properties")
public class TestConfiguration {

    @Value("${applicationUnderTest.host}")
    private String host;

    @Value("${applicationUnderTest.port}")
    private String port;

    @Value("${applicationUnderTest.buildFolder}")
    private String webAppFolderPath;

    @Value("${selenium.chrome.driver.path}")
    private String chromeDriverPath;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return Integer.parseInt(port);
    }

    public String getMainUrl() {
        return getHost() + ":" + getPort() + "/";
    }

    public String getWebAppFolderPath() {
        return webAppFolderPath;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }
}
