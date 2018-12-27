package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JobTitlesPage {
    private WebDriver driver;

    public JobTitlesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "menu_admin_Job")
    private WebElement jobTab;

    @FindBy(css = "[id^='menu_admin_viewJob']")
    private WebElement jobTitlesTab;

    @FindBy(css = "tbody > tr")
    private List<WebElement> titles;

    @FindBy(css = "tbody > tr td input")
    private List<WebElement> checkboxesOfTitles;

    @FindBy(id = "btnDelete")
    private WebElement buttonDelete;

    @FindBy(id = "dialogDeleteBtn")
    private WebElement buttonOk;

    public void toFormJobTitles() {
        jobTab.click();
        jobTitlesTab.click();
    }

    public void deleteJobTitles() {
        if (titles.size() > 2) {
            checkboxesOfTitles.get(0).click();
            checkboxesOfTitles.get(1).click();
            checkboxesOfTitles.get(2).click();
            buttonDelete.click();
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(buttonOk));
            buttonOk.click();
        } else {
            System.out.println("Not enough titles to remove");
        }
    }
}
