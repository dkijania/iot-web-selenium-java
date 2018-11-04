package com.iot.web.selenium.java.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HomeTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        navigateToMainPage();
    }

    @Test
    public void testNavigateToPricingByToolbar() {
        assertThat("By default 'Pricing' section should not be displayed", home.isPricingSectionDisplayed(),
                is(false));
        home.gotoPricingSectionByToolbar();
        assertThat("'Pricing' section should be displayed after toolbar navigation",
                home.isPricingSectionDisplayed(), is(true));
    }

    @Test
    public void testNavigateToPricingByArrowButton() {
        assertThat("By default 'Pricing' section should not be displayed", home.isPricingSectionDisplayed(),
                is(false));
        home.gotoPricingSectionByArrowButton();
        assertThat("'Pricing' section should be displayed after arrow button navigation",
                home.isPricingSectionDisplayed(), is(true));
    }

}
