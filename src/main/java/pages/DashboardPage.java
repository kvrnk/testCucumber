package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private By qiuckLaunch = By.id("panel_resizable_0_0");

    @FindBy(id = "menu_dashboard_index")
    private WebElement dashboardTab;

    @FindBy(tagName = "legend")
    private List<WebElement> legendNames;

    @FindBy(css = ".quickLaunge span")
    private List<WebElement> quickLaungeNames;

    @FindBy(css = ".quickLaunge img")
    private List<WebElement> quickLaungeImg;

    @FindBy(css = "[id^='div_legend_pim'] tbody tr")
    private List<WebElement> legendTips;

    public void toFormDashboard() {
        dashboardTab.click();
    }

    public void checkForm() {
        checkQuickLaunch();
        checkDistribution();
        checkLegend();
        checkPendingLeaveRequest();

        System.out.println("Dashboard page verified successfully!");
    }

    public void checkPendingLeaveRequest() {
        Assert.assertTrue(driver.findElement(By.id("panel_resizable_1_2")).isDisplayed());
        Assert.assertEquals("Pending Leave Requests", legendNames.get(3).getText());
        Assert.assertEquals("No Records are Available", driver.findElement(By.cssSelector(".odd td")).getText());
    }

    private void checkLegend() {
        Assert.assertTrue(driver.findElement(By.id("panel_resizable_1_1")).isDisplayed());
        Assert.assertEquals("Legend", legendNames.get(2).getText());

        if (legendTips.size() == 5) {
            Assert.assertEquals("Not assigned to Subunits", driver.findElements(By.className("legendLabel")).get(0).getText());
            Assert.assertEquals("Administration", driver.findElements(By.className("legendLabel")).get(1).getText());
            Assert.assertEquals("Finance", driver.findElements(By.className("legendLabel")).get(2).getText());
            Assert.assertEquals("IT", driver.findElements(By.className("legendLabel")).get(3).getText());
            Assert.assertEquals("Sales", driver.findElements(By.className("legendLabel")).get(4).getText());
        }
    }

    private void checkDistribution() {
        Assert.assertTrue(driver.findElement(By.id("panel_resizable_1_0")).isDisplayed());
        Assert.assertEquals("Employee Distribution by Subunit", legendNames.get(1).getText());
    }

    private void checkQuickLaunch() {
        Assert.assertTrue(driver.findElement(qiuckLaunch).isDisplayed());
        Assert.assertEquals("Quick Launch", legendNames.get(0).getText());
        Assert.assertTrue(quickLaungeImg.get(0).isDisplayed());
        Assert.assertEquals("Assign Leave", quickLaungeNames.get(0).getText());
        Assert.assertTrue(quickLaungeImg.get(1).isDisplayed());
        Assert.assertEquals("Leave List", quickLaungeNames.get(1).getText());
        Assert.assertTrue(quickLaungeImg.get(2).isDisplayed());
        Assert.assertEquals("Timesheets", quickLaungeNames.get(2).getText());
    }
}
