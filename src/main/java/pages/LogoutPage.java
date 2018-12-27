package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    private WebDriver driver;

    public LogoutPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(id = "welcome")
    private WebElement welcomeField;

    @FindBy(css = "div#welcome-menu > ul > li:nth-child(2) a")
    private WebElement logout;

    public void toLogout() {
        welcomeField.click();
    }

    public void clickLogout() {
        logout.click();
    }
}
