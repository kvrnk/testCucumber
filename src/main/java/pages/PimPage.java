package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PimPage {
    private WebDriver driver;

    public PimPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement pimTab;

    @FindBy(css = "ol li select :nth-child(2)")
    private List<WebElement> chooseSubUnit;

    @FindBy(id = "searchBtn")
    private WebElement buttonSearch;

    @FindBy(css = "tr.odd td a")
    private List<WebElement> peoplesId;

    @FindBy(css = "ol li input")
    private List<WebElement> inputFields;

    @FindBy(css = "ol li select")
    private List<WebElement> selectFields;

    public void toFormPIM() {
        pimTab.click();
    }

    public void chooseUnit() {
        chooseSubUnit.get(3).click();
        buttonSearch.click();
        if (peoplesId.size() > 0) {
            peoplesId.get(0).click();
        } else {
            System.out.println("No users with SALES attribute");
        }
    }

    public void checkForm() {
        checkFullName();
        checkProfessionalInfo();
        checkPersonalInfo();

        System.out.println("PIM page verified successfully!");
    }

    private void checkFullName() {
        Assert.assertTrue(inputFields.get(0).isDisplayed());
        Assert.assertEquals("Robert", inputFields.get(0).getAttribute("value"));

        Assert.assertTrue(inputFields.get(1).isDisplayed());
        Assert.assertEquals("", inputFields.get(1).getAttribute("value"));

        Assert.assertTrue(inputFields.get(2).isDisplayed());
        Assert.assertEquals("Craig", inputFields.get(2).getAttribute("value"));
    }

    private void checkProfessionalInfo() {
        Assert.assertTrue(inputFields.get(3).isDisplayed());
        Assert.assertEquals("0006", inputFields.get(3).getAttribute("value"));

        Assert.assertTrue(inputFields.get(4).isDisplayed());
        Assert.assertEquals("", inputFields.get(4).getAttribute("value"));

        Assert.assertTrue(inputFields.get(5).isDisplayed());
        Assert.assertEquals("", inputFields.get(5).getAttribute("value"));

        Assert.assertTrue(inputFields.get(6).isDisplayed());
        Assert.assertEquals("yyyy-mm-dd", inputFields.get(6).getAttribute("value"));
    }

    private void checkPersonalInfo() {
        Assert.assertTrue(inputFields.get(7).isDisplayed());
        Assert.assertTrue(inputFields.get(7).isSelected());

        Assert.assertTrue(inputFields.get(8).isDisplayed());
        Assert.assertFalse(inputFields.get(8).isSelected());

        Assert.assertTrue(selectFields.get(0).isDisplayed());
        Assert.assertEquals("Married", driver.findElements(By.cssSelector("ol li select > :nth-child(3)")).get(0).getText());

        Assert.assertTrue(selectFields.get(1).isDisplayed());
        Assert.assertEquals("American", driver.findElement(By.cssSelector("ol li select > :nth-child(5)")).getText());

        Assert.assertTrue(inputFields.get(9).isDisplayed());
        Assert.assertEquals("1982-10-08", inputFields.get(9).getAttribute("value"));
    }

}
