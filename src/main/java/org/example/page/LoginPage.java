package org.example.page;

import org.example.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.driver.DriverManager.getDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="login-username")
    private WebElement userName;

    @FindBy(id="login-password")
    private WebElement password;

    @FindBy(xpath = "//input[@value='LOG IN']")
    private WebElement loginBtn;


    public void login_with_valid_Cred(String user,String pwd) {
        getDriver().get(PropertiesReader.readKey("url"));
        userName.sendKeys(user);
        password.sendKeys(pwd);
        loginBtn.click();
    }
}
