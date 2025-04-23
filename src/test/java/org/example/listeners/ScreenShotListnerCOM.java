package org.example.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.example.driver.DriverManager.getDriver;

public class ScreenShotListnerCOM implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result, "FAIL");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        captureScreenshot(result, "PASS");
    }

    private void captureScreenshot(ITestResult result, String status) {

        Object testClass = result.getInstance();
        WebDriver driver = getDriver();

        String methodName = result.getName();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

        if (driver != null) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String screenshotPath = "screenshots/" + status + "_" + methodName + "_" +
                        formatter.format(calendar.getTime()) + ".png";
                FileUtils.copyFile(scrFile, new File(screenshotPath));

                // Add screenshot link to TestNG report
                org.testng.Reporter.log("<a href='" + screenshotPath + "'>[" + status + "] Screenshot</a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

