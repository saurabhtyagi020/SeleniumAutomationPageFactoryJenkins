package org.example.test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.basetest.CommanToAllTest;
import org.example.page.DashboardPage;
import org.example.page.LoginPage;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.driver.DriverManager.getDriver;

public class TestLogin extends CommanToAllTest {

    @Owner("Saurabh Tyagi")
    @Description("Verify the login page with valid credentials")
    @Test(priority = 1)
    public void test_loginForValidCred()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login_with_valid_Cred(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        String loggedUsericon=dashboardPage.dashboadLoggedUser();

        Assert.assertEquals(loggedUsericon,PropertiesReader.readKey("loggedinexpected"),"User is not loggedIn");

    }

}
