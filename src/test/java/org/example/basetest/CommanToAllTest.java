package org.example.basetest;

import org.example.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommanToAllTest {


    @BeforeMethod
    public void setUp()
    {
        DriverManager.init();
    }

    @AfterMethod
    public void down()
    {
        DriverManager.tearDown();
    }
}
