package org.example.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.basetest.CommanToAllTest;
import org.example.listeners.RetryAnalyzer;
import org.example.listeners.ScreenShotListnerCOM;
import org.example.page.LoginPage;
import org.example.utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.example.driver.DriverManager.getDriver;

@Listeners(ScreenShotListnerCOM.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestLoginWithExcel extends CommanToAllTest {

    private static final Logger logger = LogManager.getLogger(TestLoginWithExcel.class);
    @Test(dataProvider = "getData")
    public void test_login_DDT(String email,String pass)
    {
        logger.info("Test case execution started..");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login_with_invalid_Cred(email,pass);
        logger.info("Test case executed successfully!!");


    }

    @DataProvider
    public static Object[][] getData()
    {
       return ExcelUtils.readDataFromExcel("Sheet1");
    }
}
