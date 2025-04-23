package org.example.test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.basetest.CommanToAllTest;
import org.example.listeners.RetryAnalyzer;
import org.example.listeners.ScreenShotListnerCOM;
import org.example.page.DashboardPage;
import org.example.page.LoginPage;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.example.driver.DriverManager.getDriver;

@Listeners(ScreenShotListnerCOM.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestLogin extends CommanToAllTest {

    private static final Logger logger= LogManager.getLogger(TestLogin.class);
    @Owner("Saurabh Tyagi")
    @Description("Verify the login page with valid credentials")
    @Test(priority = 1)
    public void test_loginForValidCred()
    {
        logger.info("Execution started...");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login_with_valid_Cred(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        String loggedUsericon=dashboardPage.dashboadLoggedUser();

        Assert.assertEquals(loggedUsericon,PropertiesReader.readKey("loggedinexpected"),"User is not loggedIn");
        logger.info("Execution completed!!");

    }

}
