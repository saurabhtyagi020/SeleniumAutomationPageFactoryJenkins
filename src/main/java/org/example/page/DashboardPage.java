package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='round button dark menu-logoff image-left' and //a[contains(text(),'Log out')]]")
    private WebElement logoutBtn;

    public String dashboadLoggedUser()
    {
        return logoutBtn.getText();
    }
}
