package com.iot.web.selenium.java.tests;

import com.iot.web.selenium.java.data.TestData;
import com.iot.web.selenium.java.ui.page.dashboard.Dashboard;
import com.iot.web.selenium.java.ui.page.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest {

    @Autowired
    TestData testData;

    @Autowired
    Login login;

    @Autowired
    Dashboard dashboard;

    @BeforeMethod
    public void beforeTest() throws Exception {
        super.beforeTest();
        home.navigateToLogin();
    }

    @Test
    public void testUserStaysOnPageWhenLoginUnsuccessful() {
       login.login(testData.getIncorrectUser());
        assertThat("After incorrect login login page still should be opened", login.pageIsOpened(),
                is(true));
    }

    @Test
    public void testUserRedirectedWhenLoginSuccessful() {
        login.login(testData.getCorrectUser());
        assertThat("After correct login dashboard page should be opened", dashboard.pageIsOpened(),
                is(true));
    }

    @Test
    public void testUserLoginLogout() {
        login.login(testData.getCorrectUser());
        dashboard.signOut();
        assertThat("After correct login dashboard page should be opened", home.pageIsOpened(),
                is(true));

    }

}